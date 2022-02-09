package dao;

public interface UserDao {
	//select password from user_account where user_id=?
	String getPassword(String id);
}
