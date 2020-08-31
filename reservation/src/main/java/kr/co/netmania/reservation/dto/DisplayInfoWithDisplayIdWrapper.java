package kr.co.netmania.reservation.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DisplayInfoWithDisplayIdWrapper {
	private List<DisplayInfoProduct> product;
	private List<DisplayImage> productImages;
	private List<DisplayInfoImage> displayInfoImages;
	private int avgScore;
	private List<DisplayPrice> productPrices;
}
