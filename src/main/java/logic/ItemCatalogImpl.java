package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ItemDao;
import model.Condition;
import model.Item;
@Service
public class ItemCatalogImpl implements ItemCatalog {
	@Autowired
	ItemDao itemDao;
	public void putItem(Item item) {
		itemDao.putItem(item);

	}
	public List<Item> getItems(Condition c) {
		return itemDao.getItems(c);
	}
	public Integer getItemCount() {
		return itemDao.getItemCount();
	}
	public Item getItem(String code) {
		return itemDao.getItem(code);
	}
	
}
