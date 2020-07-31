package kr.co.netmania.diexam01;

import org.springframework.stereotype.Component;

@Component
public class Engine {
	public Engine() {
		System.out.println("Engine constructor");
	}
	
	public void exec() {
		System.out.println("Engine started");
	}
}
