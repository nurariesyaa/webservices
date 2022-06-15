package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Menu;
import com.example.demo.service.MenuService;

@Controller
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	// display list of menu
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginated(1, "Name", "asc", model);		
	}
	
	@GetMapping("/showNewMenuForm")
	public String showNewMenuForm(Model model) {
		// create model attribute to bind form data
		Menu menu = new Menu();
		model.addAttribute("menu", menu);
		return "new_menu";
	}
	
	@PostMapping("/saveMenu")
	public String saveMenu(@ModelAttribute("menu") Menu menu) {
		// save student to database
		menuService.saveMenu(menu);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get student from the service
		Menu menu = menuService.getMenuById(id);
		
		// set student as a model attribute to pre-populate the form
		model.addAttribute("menu", menu);
		return "update_menu";
	}
	
	@GetMapping("/deleteMenu/{id}")
	public String deleteMenu(@PathVariable (value = "id") long id) {
		
		// call delete menu method 
		this.menuService.deleteMenuById(id);
		return "redirect:/";
	}
	
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<Menu> page = menuService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Menu> listMenu = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listMenu", listMenu);
		return "index";
	}
}
