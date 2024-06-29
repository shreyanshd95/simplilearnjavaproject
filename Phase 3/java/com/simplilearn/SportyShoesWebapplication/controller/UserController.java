package com.simplilearn.SportyShoesWebapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anushka.SportyShoesWebapplication.dao.UserDAO;
import com.anushka.SportyShoesWebapplication.entity.EProduct;
import com.anushka.SportyShoesWebapplication.entity.User;

@Controller
public class UserController {
	
	
		
		@Autowired
		UserDAO userDAO;
		
		@RequestMapping(value="/list-users", method=RequestMethod.GET)
		public String listAllUsers(ModelMap map) {
			List<User> list = userDAO.getUsers();
			map.addAttribute("list",list);
			return "list-users";
		}
		
		@RequestMapping(value="/add-user", method=RequestMethod.GET)
		public String addUsers(ModelMap map) {
			User eUser = new User();
			map.addAttribute("eUser",eUser);
			return "add-user";
		}
		@RequestMapping(value="/add-user", method=RequestMethod.POST)
		public String saveUser(ModelMap map, @ModelAttribute("eUser") User eUser) {
			userDAO.addUser(eUser);
			return "add-user-success";
		}


		@RequestMapping(value="/update-user", method=RequestMethod.GET)
		public String updateUsers(ModelMap map) {
			User eUser = new User();
			map.addAttribute("eUser",eUser);
			return "update-user";
		}
		@RequestMapping(value="/update-user", method=RequestMethod.POST)
		public String updateUser(ModelMap map, @ModelAttribute("eUser") User eUser) {
			userDAO.updatesaveUser(eUser);
			return "update-user-success";
		}
		@RequestMapping(value="/delete-user", method=RequestMethod.GET)
		public String deleteUser(ModelMap map) {
			User eUser = new User();
		    map.addAttribute("eUser",eUser);
			return "delete-user";
		}
		@RequestMapping(value="/delete-user", method=RequestMethod.POST)
		public String deleteaUser(ModelMap map, @ModelAttribute("eUser") User eUser) {
			userDAO.deleteUser(eUser.getId());
			return "delete-user-success";
		}
		

}
