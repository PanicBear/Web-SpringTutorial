package kr.co.netmania.category.service;

import org.springframework.stereotype.Service;

@Service
public class CategoryService {

	public int plus(int value1, int value2) {
		return value1 + value2;
	}

	public int minus(int value1, int value2) {
		return value1 - value2;
	}
}
