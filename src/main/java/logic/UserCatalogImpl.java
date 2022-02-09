package logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;

@Service
public class UserCatalogImpl implements UserCatalog {
	@Autowired
	private UserDao userDao;
	public String getPwd(String id) {
		return userDao.getPassword(id);
	}

}
