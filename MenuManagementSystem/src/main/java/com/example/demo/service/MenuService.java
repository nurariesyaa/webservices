package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.model.Menu;

public interface MenuService {
	List<Menu> getAllMenu();
	void saveMenu(Menu menu);
	Menu getMenuById(long id);
	void deleteMenuById(long id);
	Page<Menu> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
