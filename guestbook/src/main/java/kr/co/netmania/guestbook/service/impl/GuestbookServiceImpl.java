package kr.co.netmania.guestbook.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.netmania.guestbook.dao.GuestbookDao;
import kr.co.netmania.guestbook.dao.LogDao;
import kr.co.netmania.guestbook.dto.Guestbook;
import kr.co.netmania.guestbook.dto.Log;
import kr.co.netmania.guestbook.service.GuestbookService;

@Service
public class GuestbookServiceImpl implements GuestbookService {
	
	@Autowired
	GuestbookDao guestbookDao;
	
	@Autowired
	LogDao logDao;
	

	@Override
	@Transactional
	public List<Guestbook> getGuestbooks(Integer start) {
		List<Guestbook> list = guestbookDao.selectAll(start, GuestbookService.LIMIT);
		return list;
	}

	@Override
	@Transactional(readOnly = false)
	public int deleteGuestbook(Long id, String ip) {
		int deleteCount = guestbookDao.deleteById(id);
		Log log = new Log();
		log.setIp(ip);log.setMethod("delete");
		log.setRegdate(new Date());
		logDao.insert(log);
		return deleteCount;
	}

	@Override
	@Transactional(readOnly = false)
	public Guestbook addGuestbook(Guestbook guestbook, String ip) {
		guestbook.setRegdate(new Date());
		Long id = guestbookDao.insert(guestbook);
		guestbook.setId(id);
		
		// 이 위치에서 오류나면 트랜잭션이기 때문에
		// 모든 작업 취소(트랜잭션은 분리 안됨)
		
		Log log = new Log();
		log.setIp(ip);
		log.setMethod("insert");
		log.setRegdate(new Date());
		logDao.insert(log);
		
		return guestbook;
	}

	@Override
	public int getCount() {
		return guestbookDao.selectCount();
	}

}
