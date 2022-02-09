package dao.impl;

import java.util.Calendar;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.WriteDao;
import model.Bbs;
import model.Condition;
import model.Writing;
@Repository
public class WriteDaoImpl implements WriteDao {
	@Autowired
	private SqlSession session;
	
	public Integer getMaxSeqno() {
		return session.selectOne("mapper.myMapper.getMaxSeqno");
	}

	public void insertBbs(Bbs bbs) {
		//최대 글번호를 찾아주고 null이면 초기값 0 null이 아니면 +1. 시간 데이터을 넣어준다. 그리고 삽입쿼리
		Integer seqno = this.getMaxSeqno();
		if(seqno == null)
			seqno =0;
		bbs.setSeqno(seqno+1);
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH)+1;
		int date = today.get(Calendar.DATE);
		String bbs_date = year+"/"+month+"/"+date;
		bbs.setBbs_date(bbs_date);
		session.insert("mapper.myMapper.putBbs",bbs);
		
	}

	public Integer getMaxWritingId() {
		return session.selectOne("mapper.myMapper.getMaxWritingId");
	}

	public Integer selectMaxGroupId() {
		return session.selectOne("mapper.myMapper.selectMaxGroupId");
	}

	public void updateOrderNoReply(Writing writing) {
		session.update("mapper.myMapper.updateOrderNoReply",writing);
		
	}

	public void insertWriting(Writing writing) {
		session.insert("mapper.myMapper.insertWriting",writing);
		
	}

	public Integer selectImageCount() {
		return session.selectOne("mapper.myMapper.selectImageCount");
	}

	public List<Writing> getWriting(Condition c) {
		return session.selectList("mapper.myMapper.getWriting",c);
	}
	
}
