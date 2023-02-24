package com.newlecture.web.service;

import java.util.List;

import com.newlecture.web.entity.Menu;
import com.newlecture.web.repository.MenuDao;
import com.newlecture.web.repository.jdbc.JdbcMenuDao;

public class DefaultMenuService implements MenuService {
	private MenuDao menuDao;
	
	public DefaultMenuService() {
		menuDao  = new JdbcMenuDao();
	}

	@Override
	public List<Menu> getList() {
			
		List<Menu> aa = menuDao.findAll();
		
		return aa;
	}
	
	@Override
	public void changeName(String rename) {
		menuDao.updateName(rename);
		
	}

}
