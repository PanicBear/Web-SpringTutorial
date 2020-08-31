package kr.co.netmania.reservation.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Promotion {
	private int id;
	private int productId;
	private int categoryId;
	private String categoryName;
	private String description;
	private int fileId;
}
