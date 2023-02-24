package com.newlecture.web.repository;

import java.util.List;

import com.newlecture.web.entity.Menu;

// 가장 보편적인게 가장 개인적인것이다.
// 개인이 추구하는 것에서 행복했으면 한다.

public interface MenuDao {

	List<Menu> findAll();
	void updateName(String rename);
	


}
