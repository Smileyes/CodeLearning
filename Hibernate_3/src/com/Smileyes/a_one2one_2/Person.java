package com.Smileyes.a_one2one_2;

/*
 *实体类：人 
 */
public class Person {
	private int id;// 编号
	private String name;// 姓名
	private IdCard idCard;// 身份证

	public int getId() {
		return id;
	}

	public IdCard getIdCard() {
		return idCard;
	}

	public void setIdCard(IdCard idCard) {
		this.idCard = idCard;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
