package controller;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import logic.WriteCatalog;
import model.Condition;
import model.Writing;

@Controller
public class WriteController {
	
	@Autowired
	private WriteCatalog writeCatalog;

	@RequestMapping(value="/write/writeList.html")
	ModelAndView writeList(Integer SEQNO, Integer PAGE_NO) {
		if(PAGE_NO == null) 
			PAGE_NO =1;
		ModelAndView mav = new ModelAndView("home/frame");
		if(SEQNO != null) {
			
		}
		int currentPage = PAGE_NO;
		int totalPageCount = 0;
		int startRow =0; int endRow = 0;
		int count = writeCatalog.selectImageCount();
		if(count > 0) {
			totalPageCount = count /5;
			if(count % 5 > 0) totalPageCount++;
			startRow=(currentPage -1) *5+1;
			endRow=currentPage * 5;
			if(endRow > count) endRow = count;
		}
		Condition c = new Condition();
		c.setStartRow(startRow);c.setEndRow(endRow);
		List<Writing> writeList = 
				writeCatalog.getWriting(c);
		mav.addObject("LIST",writeList);
		mav.addObject("count",count);
		mav.addObject("startRow",startRow);
		mav.addObject("endRow",endRow);
		mav.addObject("pageCount",totalPageCount);
		mav.addObject("currentPage",currentPage);
		mav.addObject("BODY","image_list.jsp");
		return mav;
	}
	@RequestMapping(value="/write/write.html", method=RequestMethod.POST)
	ModelAndView writeSubmit(@Valid Writing writing, BindingResult br, HttpSession session
			,Integer parent_id, Integer order_no, Integer group_id) {

		//???????????? ???????????? ????????????. ????????????????????? ?????????
		MultipartFile multiFile=writing.getImage();
		String fileName=null; String path=null;
		OutputStream outputStream=null;
		if(multiFile != null) {//????????? ????????? ???????????? ??????
			fileName=multiFile.getOriginalFilename();
			ServletContext ctx=session.getServletContext();// ????????? ?????? ????????? ?????????
			path=ctx.getRealPath("WEB-INF/upload/"+fileName);
			System.out.println("???????????????:"+path);//????????? ???????????? ????????? ?????????????????? ?????????
			try {//????????? ??????????????? ??????
				outputStream=new FileOutputStream(path);
				BufferedInputStream bis =
					new BufferedInputStream(
						multiFile.getInputStream());//???????????? ?????? ???????????? getInputStream ??????
				byte[] buffer = new byte[8156];//8k ????????? ?????? ???????????????
				int read = 0;
				while( (read=bis.read(buffer))>0) {
					outputStream.write(buffer,0,read);//????????? ??????
				}
				if(outputStream != null) outputStream.close();//os????????????
			}catch(Exception e) {
				e.printStackTrace();
			}
			writing.setImage_name(fileName);
		}
		Integer maxId=writeCatalog.getMaxWriting_id();
		if(maxId == null) maxId = 0;
		if(writing.getParent_id() == null) {//???????????????
			writing.setParent_id(0);//?????? ???
			writing.setOrder_no(0);//????????????
			//??????ID??????
			Integer gId=writeCatalog.selectMaxGroupId();
			if(gId == null) gId = 0;
			writing.setGroup_id(gId+1);
		}else {//????????? ?????? 
			writing.setParent_id(parent_id);
			writing.setGroup_id(group_id);
			writing.setOrder_no(order_no);
			writeCatalog.updateOrderNoReply(writing);
		}
		writing.setWriting_id(maxId + 1);
		Calendar today=Calendar.getInstance();
		int year=today.get(Calendar.YEAR);
		int month=today.get(Calendar.MONTH) + 1;
		int date=today.get(Calendar.DATE);
		String registerDate=year+"/"+month+"/"+date;
		writing.setRegister_date(registerDate);
		writeCatalog.insertWriting(writing);//DB??????
		ModelAndView mav=new ModelAndView("home/frame");
		mav.addObject("BODY",
			"writeResult.jsp?SEQNO="+(maxId+1));
		return mav;
	}
	@RequestMapping(value="/write/writeForm.html")
	ModelAndView writeTemplate(HttpSession session) {
		ModelAndView mav = new ModelAndView("home/frame");
		String id = (String) session.getAttribute("loginUser");
		if(id == null) {
			mav.addObject("BODY","writeFormLogin.jsp");
		}else {
			mav.addObject("BODY","writeForm.jsp");
			mav.addObject(new Writing());
		}
		return mav;
	}
}
