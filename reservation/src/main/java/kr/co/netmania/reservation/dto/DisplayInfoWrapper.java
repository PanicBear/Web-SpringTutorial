package kr.co.netmania.reservation.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DisplayInfoWrapper {
	private int totalCount;
	private int productCount;
	private List<DisplayInfo> products;
}
