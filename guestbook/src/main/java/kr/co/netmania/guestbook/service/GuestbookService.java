package kr.co.netmania.guestbook.service;

import java.util.List;

import kr.co.netmania.guestbook.dto.Guestbook;

public interface GuestbookService {
	public static final Integer LIMIT = 5;
	public List<Guestbook> getGuestbooks(Integer start);
	public int deleteGuestbook(Long id, String ip);
	public Guestbook addGuestbook(Guestbook guestbook, String ip);
	public int getCount();
}
