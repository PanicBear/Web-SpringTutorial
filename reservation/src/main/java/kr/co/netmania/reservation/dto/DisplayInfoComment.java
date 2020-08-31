package kr.co.netmania.reservation.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DisplayInfoComment {
	private int id;
	private int productId;
	private int reservationInfoId;
	private int score;
	private String comment;
	private String createDate;
	private String modifyDate;
	private String reservationUserCommentImages;
}
