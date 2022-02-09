package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {
	@RequestMapping(value="/logout.html")//logout.html에만 해도 매핑이 된다 하지만 알기 쉽게 규칙상 /logout/frame.html이 좋을거 같다.
	public ModelAndView logout(HttpSession session) {
		ModelAndView mav = new ModelAndView("home/frame");
		session.removeAttribute("loginUser");
		mav.addObject("BODY","logoutResult.jsp");
		return mav;
	}
}
