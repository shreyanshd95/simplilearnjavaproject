package com.simplilearn.SportyShoesWebapplication.controller;

	import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anushka.SportyShoesWebapplication.dao.EproductDAO;
import com.anushka.SportyShoesWebapplication.dao.LoginDAO;
import com.anushka.SportyShoesWebapplication.entity.EProduct;
import com.anushka.SportyShoesWebapplication.entity.User;


@Controller
public class LoginController {
	@Autowired
	LoginDAO loginDAO;
	
	@Autowired
	EproductDAO productDAO;
	@RequestMapping(value="/ulogin", method=RequestMethod.GET)
	public String lofinUsers(ModelMap map) {
		User eUser = new User();
		map.addAttribute("eUser",eUser);
		return "ulogin";
	}
	@RequestMapping(value="/ulogin", method=RequestMethod.POST)
	public String saveUser(ModelMap map, @ModelAttribute("eUser") User eUser) {
		loginDAO.loginUser(eUser);
	
		
		List<EProduct> list = productDAO.getProducts();
		map.addAttribute("list",list);
		return "user-list-products";
	
	}
	}