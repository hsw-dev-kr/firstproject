package controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.ItemCatalog;
import logic.ReadCatalog;
import model.Bbs;
import model.Cart;
import model.CartItem;
import model.Condition;
import model.Item;

@Controller
public class ReadController {
	@Autowired
	private ReadCatalog readCatalog;
	@Autowired
	private ItemCatalog itemCatalog;

	
	@RequestMapping(value="/read/ItemDetail.html")
	public ModelAndView readItemDetail(String CODE) {
		Item item = itemCatalog.getItem(CODE);
		ModelAndView mav = new ModelAndView("home/frame");
		mav.addObject("ITEM",item);
		mav.addObject("BODY","item_detail.jsp");
		return mav;
	}
	@RequestMapping(value="/read/item.html")
	public ModelAndView readItemList(Integer pageNo) {
		Integer cnt = itemCatalog.getItemCount();
		if(cnt == null)
			cnt = 0;
		int startRow = 0; int endRow = 0; int pageCnt = 0; int currentPage =0;
		if(pageNo == null)
			currentPage =1;
		else
			currentPage = pageNo;
		if(cnt > 0) {
			pageCnt = cnt / 5;
			if(cnt % 5 > 0)
				pageCnt++;
			startRow = (currentPage-1)*5+1;
			endRow = currentPage*5;
			if(endRow > cnt)
				endRow = cnt;
		}
		Condition c = new Condition();
		c.setStartRow(startRow);c.setEndRow(endRow);
		List<Item> itemList = itemCatalog.getItems(c);
		ModelAndView mav = new ModelAndView("home/frame");
		mav.addObject("ITEM_LIST",itemList);
		mav.addObject("PAGE_CNT",pageCnt);
		mav.addObject("BODY","item_list.jsp");
		return mav;
	}
	
	@RequestMapping(value="/read/readDetail.html",method=RequestMethod.GET)
	public ModelAndView BbsDetail(Integer SEQNO) {
		//해당 글 번호의 글 정보를 얻어온다.
		Bbs bbs = readCatalog.getDetailBbs(SEQNO);
		ModelAndView mav = new ModelAndView("home/frame");
		mav.addObject("BBS",bbs);
		mav.addObject("BODY","bbsDetail.jsp");
		//글 정보를 mav 담는다.
		//mav의 뷰를 설정한다.
		return mav;
	}
	@RequestMapping(value="/read/read.html")
	public ModelAndView readBbsList(Integer pageNo) {
		Integer cnt = readCatalog.getBbsCount();
		if(cnt == null)
			cnt = 0;
		int startRow=0; int endRow=0;int pageCnt=0; int currentPage=0;
		if(pageNo == null)
			currentPage=1;
		else 
			currentPage = pageNo;
		if(cnt>0) {
			pageCnt = cnt/5;
			if(cnt % 5 > 0) 
				pageCnt++;
			startRow = (currentPage-1)*5+1;
			endRow = currentPage * 5;
			if(endRow > cnt)
				endRow = cnt;
			}
		Condition c= new Condition();
		c.setStartRow(startRow);c.setEndRow(endRow);
		List<Bbs> bbsList = readCatalog.ReadBbs(c);
		ModelAndView mav = new ModelAndView("home/frame");
		mav.addObject("BBS_LIST",bbsList);
		mav.addObject("pageCnt",pageCnt);
		mav.addObject("BODY","bbsListView.jsp");
		return mav;
		//1.인자로 페이지넘버를 받는다.2.전체글갯수를 가져온다.글갯수가 null이면 초기값 0 ,시작행과 끝행 현재페이지 페이지카운트 총 4개의 int변수를 생성한다.
		//3.인자로 받은 페이지넘버가 null이면 현재페이지변수는 1  페이지넘버가 null아니면 페이지넘버의 값을 현재페이지값으로 넣는다.
		//4.글 갯수가 0보다 크다면 글갯수/5;를해서 페이지카운트에 넣어주고 글갯수 %5해서 0보다 크면 페이지카운트를 하나 늘려준다.
		//5.(현제페이지-1)*5+1 을 시작행 변수에 넣어주고  현재페이지 *5를 끝행 변수에 넣어준다.
		//6.끝행갯수가 글갯수보다 크면 글갯수를 끝행변수에 넣어준다.
		//7.Condition 모델을 만든다. 시작행과 끝행 갯수를 담을 변수도 만든다. 반환값으로 받은 List를 mav에 넣어준다. mav에 페이지카운트도 넣어준다.
	}
}
