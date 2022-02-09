package logic;

import java.util.List;

import model.Condition;
import model.Item;

public interface ItemCatalog {
	void putItem(Item item);
	List<Item> getItems(Condition c);
	Integer getItemCount();
	Item getItem(String code);
}
