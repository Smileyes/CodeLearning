package com.Smileyes.dao;

import org.junit.Test;

import com.Smileyes.entity.Dept;

public class DeptDao extends BaseDao<Dept> {

	@Test
	public void abcdefg() {
		this.remove(2);
	}

	@Override
	public Dept find(Dept t) {
		// TODO Auto-generated method stub
		return null;
	}
}
