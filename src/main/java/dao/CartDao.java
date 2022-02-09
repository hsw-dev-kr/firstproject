package dao;

import java.util.List;

import model.CartItem;

public interface CartDao {
	Integer getMaxCartSeqno();
	void insertCart(CartItem cartItem);
	void updateCart(CartItem cartItem);
	void deleteCart(CartItem cartItem);
	List<CartItem> selectCart(String id);
}
