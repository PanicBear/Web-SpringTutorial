package kr.co.netmania.diexam01;

public class UserBean {

//	1) 기본 생성자
//	2) private 필드
//	3) getter, setter 메서드

	private String name;
	private int age;
	private boolean male;

	public UserBean() {
	}

	public UserBean(String name, int age, boolean male) {
		super();
		this.name = name;
		this.age = age;
		this.male = male;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isMale() {
		return male;
	}

	public void setMale(boolean male) {
		this.male = male;
	}

}
