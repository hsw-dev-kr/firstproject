package logic;

import java.util.List;

import model.Bbs;
import model.Condition;

public interface ReadCatalog {
	List<Bbs> ReadBbs(Condition c);
	Integer getBbsCount();
	Bbs getDetailBbs(Integer seqno);
}
