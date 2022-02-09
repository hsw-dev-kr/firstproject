package dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.UserDao;
@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SqlSession session;
	public String getPassword(String id) {
		return session.selectOne("mapper.myMapper.getPwd",id);
	}

}
