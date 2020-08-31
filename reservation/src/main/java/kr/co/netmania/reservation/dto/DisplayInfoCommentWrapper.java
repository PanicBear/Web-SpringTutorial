package kr.co.netmania.reservation.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DisplayInfoCommentWrapper {
	private int totalCount;
	private int commentCount;
	private List<DisplayInfoComment> reservationUserComments;
}
