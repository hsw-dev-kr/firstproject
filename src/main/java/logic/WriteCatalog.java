package logic;

import java.util.List;

import model.Bbs;
import model.Condition;
import model.Writing;

public interface WriteCatalog {
	Integer getMaxSeqno();
	void putBbs(Bbs bbs);
	
	Integer getMaxWriting_id();
	Integer selectMaxGroupId();
	void updateOrderNoReply(Writing writing);
	void insertWriting(Writing writing);
	
	Integer selectImageCount();
	List<Writing> getWriting(Condition c);
}
