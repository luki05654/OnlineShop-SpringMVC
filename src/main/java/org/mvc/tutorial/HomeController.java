package org.mvc.tutorial;

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
	
	private final static String GREETING = "greeting";	
	private final static String TAGLINE = "tagline";
	
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
		
		model.addAttribute(GREETING, greetingVal );
		model.addAttribute(TAGLINE, taglineVal );
		
		return "welcome";
	}
	
}
