package dao;

import java.util.List;

import model.Bbs;
import model.Condition;
import model.Writing;

public interface WriteDao {
	Integer getMaxSeqno();
	void insertBbs(Bbs bbs);
	
	Integer getMaxWritingId();
	Integer selectMaxGroupId();
	void updateOrderNoReply(Writing writing);
	void insertWriting(Writing writing);
	Integer selectImageCount();
	List<Writing> getWriting(Condition c);
}
