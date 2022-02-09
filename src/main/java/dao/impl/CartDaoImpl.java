package dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.CartDao;
import model.CartItem;
@Repository
public class CartDaoImpl implements CartDao {
	@Autowired
	private SqlSession session;
	public Integer getMaxCartSeqno() {
		return session.selectOne("mapper.myMapper.getMaxCartSeqno");
	}

	public void insertCart(CartItem cartItem) {
		session.insert("mapper.myMapper.insertCart",cartItem);
	}

	public void updateCart(CartItem cartItem) {
		session.update("mapper.myMapper.updateCart",cartItem);
		
	}
	
	public void deleteCart(CartItem cartItem) {
		session.delete("mapper.myMapper.deleteCart",cartItem);
		
	}

	public List<CartItem> selectCart(String id) {
		return session.selectList("mapper.myMapper.getIdCartList",id);
	}
	
}
