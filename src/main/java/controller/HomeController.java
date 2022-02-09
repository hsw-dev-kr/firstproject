package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Bbs;

@Controller
public class HomeController {

	@RequestMapping(value="/homed/index")
	public ModelAndView template() {
		ModelAndView mav = new ModelAndView("home/frame");
		return mav;
	}

}
