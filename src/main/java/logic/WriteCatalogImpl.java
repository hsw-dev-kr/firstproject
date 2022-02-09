package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.WriteDao;
import model.Bbs;
import model.Condition;
import model.Writing;

@Service
public class WriteCatalogImpl implements WriteCatalog {
	@Autowired
	private WriteDao writeDao;
	
	public Integer getMaxSeqno() {
		return writeDao.getMaxSeqno();
	}

	public void putBbs(Bbs bbs) {
		writeDao.insertBbs(bbs);

	}

	public Integer getMaxWriting_id() {
		return writeDao.getMaxWritingId();
	}

	public Integer selectMaxGroupId() {
		return writeDao.selectMaxGroupId();
	}

	public void updateOrderNoReply(Writing writing) {
		writeDao.updateOrderNoReply(writing);
		
	}

	public void insertWriting(Writing writing) {
		writeDao.insertWriting(writing);
		
	}

	public Integer selectImageCount() {
		return writeDao.selectImageCount();
	}

	public List<Writing> getWriting(Condition c) {
		return writeDao.getWriting(c);
	}
	
}
