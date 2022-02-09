package model;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CartDao;
@Service
public class Cart {
	@Autowired
	private CartDao cartDao;

	LinkedList<String> codeList = new LinkedList<String>();
	LinkedList<Integer> numList = new LinkedList<Integer>();
	public void setCodeList(int index, String code) {
		this.codeList.add(index,code);
	}
	public void setNumList(int index, Integer num) {
		this.numList.add(index,num);
	}

	public List<CartItem> getCart(String id){
		return this.cartDao.selectCart(id);

	}
	public void addCart(String code, Integer num, String id) {
		for(int i=0; i<codeList.size();i++) {
			if(codeList.get(i).equals(code)) {
				numList.set(i,numList.get(i)+num);
				//업데이트 메서드
				updateCart(code,numList.get(i),id);
				return;
			}
		}
		codeList.add(code);numList.add(num);
		insertCart(code,num,id);

	}
	private void updateCart(String code,Integer num,String id) {
		CartItem cartItem = new CartItem();
		cartItem.setCode(code);cartItem.setNum(num);cartItem.setId(id);
		cartDao.updateCart(cartItem);
	}
	private void insertCart(String code,Integer num, String id) {
		Integer seqno = cartDao.getMaxCartSeqno();
		if(seqno == null)
			seqno =1;
		else
			seqno= seqno+1;
		CartItem cartItem = new CartItem();
		cartItem.setSeqno(seqno);cartItem.setCode(code);cartItem.setNum(num);
		cartItem.setId(id);	
		cartDao.insertCart(cartItem);
	}
	public void modify(String code, Integer number, String id) {
		for(int i=0; i<codeList.size(); i++) {
			if(codeList.get(i).equals(code)) {
				numList.set(i, number);
				this.updateCart(code,number,id);
				return ;
			}
		}
		
	}
	public void delete(String code, String id) {
		CartItem cartItem = new CartItem();
		cartItem.setCode(code);cartItem.setId(id);
		cartDao.deleteCart(cartItem);
		
	}

}
