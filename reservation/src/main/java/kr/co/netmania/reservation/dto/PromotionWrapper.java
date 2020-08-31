package kr.co.netmania.reservation.dto;

import java.util.List;

import lombok.Getter;
import lombok.ToString;
import lombok.Setter;

@Getter
@Setter
@ToString
public class PromotionWrapper {
	private int size;
	private List<Promotion> items;
}
