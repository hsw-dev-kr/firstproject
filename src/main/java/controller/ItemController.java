package controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.ItemCatalog;
import model.Item;
import model.User;

@Controller
public class ItemController {
	@Autowired
	ItemCatalog itemCatalog;
	@RequestMapping(value="/item/itemSubmit.html",method=RequestMethod.POST)
	public ModelAndView itemPostSubmit(@Valid Item item, BindingResult rs, HttpSession session) {
		ModelAndView mav = new ModelAndView("home/frame");
		if(rs.hasErrors()) {
			mav.getModel().putAll(rs.getModel());
			mav.addObject("BODY","item_input.jsp");
			return mav;
		}
		String id = (String) session.getAttribute("loginUser");
		if(id == null) {
			mav.addObject("BODY","nologin.jsp");
			mav.addObject("ITEM","nobody");
			mav.addObject(new User());
			return mav;
		}
		itemCatalog.putItem(item);
		mav.addObject("BODY","item_list.jsp");
		return mav;
	}
	@RequestMapping(value="/item/template.html")
	public ModelAndView itemToTemplate() {
		ModelAndView mav = new ModelAndView("home/frame");
		mav.addObject(new Item());
		mav.addObject("BODY","item_input.jsp");
		return mav;
	}
}
