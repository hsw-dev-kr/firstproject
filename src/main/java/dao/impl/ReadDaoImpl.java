package dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.ReadDao;
import model.Bbs;
import model.Condition;
@Repository
public class ReadDaoImpl implements ReadDao {
	@Autowired
	SqlSession session;
	public List<Bbs> ReadBbs(Condition c) {
		return session.selectList("mapper.myMapper.readBbsList",c);
	}
	public Integer getBbsCount() {
		return session.selectOne("mapper.myMapper.bbsCount");
	}
	public Bbs getDetailBbs(Integer seqno) {
		return session.selectOne("mapper.myMapper.getDetailBbs",seqno);
	}
	
}
