package org.mvc.tutorial.controller;

import org.mvc.tutorial.views.ViewPages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private final static Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private final static String GREETING_KEY = "greeting";	
	private final static String TAGLINE_KEY = "tagline";
	
	private String greetingVal;
	private String taglineVal;	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/")
	public String home(Model model) {	
		logger.info("Inside HomeController: home()");
		
		greetingVal = "Witaj w sklepie internetowym!";
		taglineVal = "W jedyym takim sklepie";
		
		model.addAttribute(GREETING_KEY, greetingVal );
		model.addAttribute(TAGLINE_KEY, taglineVal );
		
		return "forward:/welcome/greeting";
		//return ViewPages.WELCOME;
	}
	
	@RequestMapping(value = "/welcome/greeting")
	public String greeting() {
		return ViewPages.WELCOME;
		//return "redirect:/welcome/greeting";
	}
}
