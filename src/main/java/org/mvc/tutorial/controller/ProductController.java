package org.mvc.tutorial.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.mvc.tutorial.domain.Product;
import org.mvc.tutorial.domain.service.ProductService;
import org.mvc.tutorial.exception.NoProductsFoundUnderCategoryException;
import org.mvc.tutorial.exception.ProductNotFoundException;
import org.mvc.tutorial.validator.ProductValidator;
import org.mvc.tutorial.validator.UnitsInStockValidator;
import org.mvc.tutorial.views.ViewPages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/" + ViewPages.PRODUCTS)
public class ProductController {
	private final static String PRODUCTS_KEY = "products";
	private static final String PRODUCT_KEY = "product";
	private static final String NEW_PRODUCT_KEY = "newProduct";

	@Autowired
	private ProductService productService;
	@Autowired
	private UnitsInStockValidator unitsInStockValidator;
	@Autowired
	private ProductValidator productValidator;

	@RequestMapping
	public String list(Model model) {
		model.addAttribute(PRODUCTS_KEY, productService.getAllProducts());

		return ViewPages.PRODUCTS;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest request, ProductNotFoundException exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("invalidProductId", exception.getProductId());
		mav.addObject("exception", exception);
		mav.addObject("url", request.getRequestURL()+"?"+request.getQueryString());
		mav.setViewName(ViewPages.PRODUCT_NOT_FOUND);
		
		return mav;		
	}

	@RequestMapping("/{category}")
	public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) {
		List<Product> products = productService.getProductsByCategory(productCategory);
		if(products == null || products.isEmpty()) {
			throw new NoProductsFoundUnderCategoryException();
		}
		model.addAttribute(PRODUCTS_KEY, products);

		return ViewPages.PRODUCTS;
	}

	@RequestMapping("/all")
	public String allProducts(Model model) {
		model.addAttribute(PRODUCTS_KEY, productService.getAllProducts());

		return ViewPages.PRODUCTS;
	}

	@RequestMapping("/filter/{ByCriteria}")
	public String getProductsByFilter(@MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParams,
			Model model) {
		model.addAttribute("products", productService.getProductsByFilter(filterParams));

		return ViewPages.PRODUCTS;
	}

	@RequestMapping("/product")
	public String getProductById(Model model, @RequestParam("id") String productId) {
		model.addAttribute(PRODUCT_KEY, productService.getProductById(productId));

		return ViewPages.PRODUCT;
	}

	@RequestMapping("/{category}/{price}")
	public String getByAdvancedFilter(Model model, @PathVariable("category") String category,
			@MatrixVariable(pathVar = "price") Map<String, String> priceFilter,
			@RequestParam("manufacturer") String manufacturer) {

		model.addAttribute(PRODUCTS_KEY,
				productService.getProductsByCategoryPriceScopeAndManufacturer(category, priceFilter, manufacturer));

		return ViewPages.PRODUCTS;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
		Product newProduct = new Product();
		model.addAttribute(NEW_PRODUCT_KEY, newProduct);

		return ViewPages.ADD_PRODUCT;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") @Valid Product newProduct, BindingResult result,
			HttpServletRequest request) {
		
		if(result.hasErrors()) {
			return ViewPages.ADD_PRODUCT;
		}
		
		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException(
					"Próba wiązania niedozwolonych pól:" + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}

		MultipartFile productImage = newProduct.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		if (productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(
						new File(rootDirectory + "resources\\images\\" + newProduct.getProductId() + ".png"));
			} catch (Exception e) {
				throw new RuntimeException("Niepowodzenie podczas próby zapisu obrazka produktu", e);
			}
		}
		
		MultipartFile productManual = newProduct.getProductManual();
		if (productManual != null && !productManual.isEmpty()) {
			try {
				productManual.transferTo(
						new File(rootDirectory + "resources\\manuals\\" + newProduct.getProductId() + ".pdf"));
			} catch (Exception e) {
				throw new RuntimeException("Niepowodzenie podczas próby zapisu instrukcji obsługi produktu", e);
			}
		}

		productService.addProduct(newProduct);

		return "redirect:/" + ViewPages.PRODUCTS;
	}

	@RequestMapping("/invalidPromoCode")
	public String invalidPromoCode() {
		return ViewPages.INVALID_PROMO_CODE;
	}
	
	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setValidator(productValidator);
		binder.setDisallowedFields("unitsInOrder", "discontinued");
		binder.setAllowedFields("productId", "name", "unitPrice", "description", "manufacturer", "category",
				"condition", "unitsInStock", "productImage", "productManual", "language");
	}
}
