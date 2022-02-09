package controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.UserCatalog;
import model.Cart;
import model.CartItem;
import model.User;

@Controller
public class LoginController {

	@Autowired
	private UserCatalog userCatalog;
	@Autowired
	private Cart cart;
	@RequestMapping(value="/login/imageLogin.html")
	public ModelAndView imageLogin(@Valid @ModelAttribute("guest")User guest,BindingResult br, HttpSession session) {
		ModelAndView mav = new ModelAndView("home/frame");
		if(br.hasErrors()) {
			return mav;
		}

		String password = userCatalog.getPwd(guest.getUser_id());
		if(password == null || !guest.getPassword().equals(password)) {
			mav.setViewName("home/loginResult");
		}else {
			session.setAttribute("loginUser", guest.getUser_id());
			List<CartItem> cartList = cart.getCart(guest.getUser_id());
			if(cartList != null) {
				Iterator<CartItem> it = cartList.iterator();
				int i = 0;
				while(it.hasNext()) {
					CartItem cartItem = (CartItem)it.next();
					this.cart.setCodeList(i, cartItem.getCode());
					this.cart.setNumList(i, cartItem.getNum());
					i++;
				}
				session.setAttribute("CART", this.cart);
			}
			mav.addObject("imageLogin","SUCCESS");
			mav.setViewName("home/loginResult");
		}
		return mav;
	}

	@RequestMapping(value="/login/frame.html")
	public ModelAndView loginPost(@Valid @ModelAttribute("guest")User guest,
			BindingResult br, HttpSession session) {
		ModelAndView mav = new ModelAndView("home/frame");
		if(br.hasErrors()){
			mav.getModel().putAll(br.getModel());
			mav.addObject("HEADER","login.jsp");
			return mav;
		}
		String password = userCatalog.getPwd(guest.getUser_id());
		if(password == null || !password.equals(guest.getPassword())) {
			mav.addObject("BODY","loginResult.jsp");
			return mav;
		}else {
			session.setAttribute("loginUser", guest.getUser_id());
			List<CartItem> cartList = 
					cart.getCart(guest.getUser_id());
			if(cartList != null) {
				Iterator it = cartList.iterator();
				int i=0;
				while(it.hasNext()) {
					CartItem cartItem = (CartItem)it.next();
					this.cart.setCodeList(i, cartItem.getCode());
					this.cart.setNumList(i, cartItem.getNum());
					i++;
				}
				session.setAttribute("CART", this.cart);
			}
			mav.addObject("BODY","loginResult.jsp");
		}
		return mav;
	}
	@RequestMapping(value="login/login.html")
	public ModelAndView loginTemplate() {
		ModelAndView mav = new ModelAndView("home/login");
		mav.addObject("guest",new User());
		return mav;
	}
}
