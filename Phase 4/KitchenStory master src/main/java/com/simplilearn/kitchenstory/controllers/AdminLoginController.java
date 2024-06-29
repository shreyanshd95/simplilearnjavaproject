package com.simplilearn.kitchenstory.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.simplilearn.kitchenstory.entity.Admin;
import com.simplilearn.kitchenstory.repository.AdminRepository;

@Controller
public class AdminLoginController {

	@Autowired
	AdminRepository adminRepository;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
	public RedirectView adminLogin(@RequestParam("username") String adminIdInput,
			@RequestParam("password") String adminPwdInput, HttpServletResponse response, HttpSession session)
			throws IOException {
		try {
			Admin adminObj = adminRepository.findById(adminIdInput);
			if (adminObj == null) {
				return new RedirectView("error.html");
			} else {
				String adminPwd = adminObj.getPwd();
				session.setAttribute("adminId", adminIdInput);
				if (adminPwd.equals(adminPwdInput)) {
					return new RedirectView("adminlanding.html");
				} else {
					return new RedirectView("adminerror.html");
				}
			}

		} catch (Exception e) {
			logger.info("Error occured at AdminLoginController : " + e.getMessage());
			return new RedirectView("error.html");
		}

	}

}
