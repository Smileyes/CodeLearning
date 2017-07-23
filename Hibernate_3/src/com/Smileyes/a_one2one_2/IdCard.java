package com.Smileyes.a_one2one_2;

public class IdCard {
	private String cardNum;// 身份证号
	private String address;// 家庭住址
	private Person person;// 人
	private int person_id;// 主键

	public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}

	public String getCardNum() {
		return cardNum;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
