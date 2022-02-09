package dao;

import java.util.List;

import model.Bbs;
import model.Condition;

public interface ReadDao {
	List<Bbs> ReadBbs(Condition c);
	Integer getBbsCount();
	Bbs getDetailBbs(Integer seqno);
}
