package controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.WriteCatalog;
import model.Bbs;
import model.User;
@Controller
public class BbsController {
	
	@Autowired
	private WriteCatalog writeCatalog;
	
	@RequestMapping(value="/bbs/bbsTemplate.html")
	public ModelAndView bbsTemplate() {
		ModelAndView mav = new ModelAndView("home/frame");
		mav.addObject(new Bbs());
		mav.addObject("BODY","bbsInput.jsp");
		return mav;
	}
	@RequestMapping(value="/bbs/write.html", method=RequestMethod.POST)
	public ModelAndView bbsWrite(@Valid Bbs bbs,BindingResult rs, HttpSession session) {
		//1.로그인을 하지 않았다면 로그인 페이지로 이동 2.유효성 검증 실시 3.쿼리작성,dao,daoimpl,logic 작성
		ModelAndView mav = new ModelAndView("home/frame");
		if(rs.hasErrors()) {
			mav.getModel().putAll(rs.getModel());
			mav.addObject("BODY","bbsInput.jsp");
			return mav;
		}
		String id = (String)session.getAttribute("loginUser");
		if(id == null) {
			mav.addObject("BODY","nologin.jsp");
			mav.addObject("RESULT","nobody");
			mav.addObject(new User());//nologin.jsp에서 form:form에 modelAttribute가 있다.
			return mav;
		}else {
			bbs.setId(id);
			writeCatalog.putBbs(bbs);
			return new ModelAndView("redirect:/read/read.html");
		}
		
	}
}
