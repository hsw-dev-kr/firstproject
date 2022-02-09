package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ReadDao;
import model.Bbs;
import model.Condition;
@Service
public class ReadCatalogImpl implements ReadCatalog {
	@Autowired
	private ReadDao readDao;

	public List<Bbs> ReadBbs(Condition c) {
		return readDao.ReadBbs(c);
	}


	public Integer getBbsCount() {
		return readDao.getBbsCount();
	}


	public Bbs getDetailBbs(Integer seqno) {
		return readDao.getDetailBbs(seqno);
	}
	

}
