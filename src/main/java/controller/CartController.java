package controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.UserCatalog;
import model.Cart;
import model.CartItem;
import model.User;

@Controller
public class CartController {
	@Autowired
	private Cart cart;	
	@Autowired
	private UserCatalog userCatalog;


	@RequestMapping(value="/cart/modify.html")
	public ModelAndView cartModeify(String CODE, Integer NUMBER, String BTN,HttpSession session) {
		String id = (String) session.getAttribute("loginUser");
		if(BTN.equals("수정")) {
			cart.modify(CODE,NUMBER,id);
		}else if(BTN.equals("삭제")) {
			cart.delete(CODE,id);
		}
		return new ModelAndView("redirect:/cart/cartShow.html");
	}
	@RequestMapping(value="/cart/cartShow.html")
	public ModelAndView readItemShow(HttpSession session) {
		ModelAndView mav = new ModelAndView("home/frame");
		String id = (String) session.getAttribute("loginUser");
		if(id == null) {
			return mav;
		}
		List<CartItem> cartList = cart.getCart(id);
		Iterator<CartItem> it = cartList.iterator();
		int totalAmount =0;
		if(cartList.size() > 0) {
			while(it.hasNext()) {
				CartItem cartItem = (CartItem) it.next();
				int total = cartItem.getPrice() * cartItem.getNum();
				totalAmount = totalAmount +total;
			}
			mav.addObject("SIZE","YES");
		}else {
			mav.addObject("SIZE","NO");
		}
		mav.addObject("totalAmount",totalAmount);
		mav.addObject("CART_LIST",cartList);
		mav.addObject("BODY","cartListView.jsp");
		return mav;
		
	}


	@RequestMapping(value="/cart/cartAdd.html")
	public ModelAndView cartAdd(String code,HttpSession session) {
		//1.로그인세션을 확인한다. 로그인이 되어 있지 않으면 비로그인 처리를 한다. (현재 윈도창이므로 새로 만든다.)
		//2.카트세션을 확인한다. 카트가 널이면 카트를 생성한다.
		//3.addCart(CODE,1,id) 메서드를 만든다. 카트를 세션에 저장한다. 카트 갯수를mav에"ITEM_NUM",1를 넘겨준다.
		String id = (String)session.getAttribute("loginUser");
		if(id == null) {//비로그인처리
			ModelAndView mav = new ModelAndView(
					"redirect:/cart/login.html");
			return mav;
		}else {
			Cart cart = (Cart)session.getAttribute("CART");
			if(cart == null)
				cart = this.cart;
			cart.addCart(code, 1, id);
			ModelAndView mav = new ModelAndView("home/addCartResult");
			mav.addObject("CART",cart);
			mav.addObject("ITEM_NUM",1);
			return mav;
		}
	}
	@RequestMapping(value="/cart/login.html",method=RequestMethod.POST)
	public ModelAndView loginCartSubmit(@Valid User user,BindingResult rs, HttpSession session) {
		if(rs.hasErrors()) {
			ModelAndView mav = new ModelAndView("home/cartLogin");
			mav.getModel().putAll(rs.getModel());
			return mav;
		}
		ModelAndView mav = new ModelAndView("home/loginResult");
		String password = userCatalog.getPwd(user.getUser_id());
		if(! password.equals(user.getPassword())) {
			mav.addObject("cartLogin","YES");
			return mav;
		}else {
			mav.addObject("cartLogin","success");
			session.setAttribute("loginUser", user.getUser_id());
			return mav;
		}
	}
	@RequestMapping(value="/cart/login.html")
	public ModelAndView cartTemplate() {
		ModelAndView mav = new ModelAndView("home/cartLogin");
		mav.addObject("RESULT","nocart");
		mav.addObject(new User());
		return mav;
	}
}
