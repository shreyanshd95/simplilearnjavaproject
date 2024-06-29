package com.simplilearn.kitchenstory.controllers;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simplilearn.kitchenstory.entity.Admin;
import com.simplilearn.kitchenstory.repository.AdminRepository;

@Controller
public class AdminPasswordChangeController {

	@Autowired
	AdminRepository adminRepository;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/changepassword", method = RequestMethod.POST)
	public String adminLogin(@RequestParam("oldPsw") String oldPwdInput, @RequestParam("newPsw") String newPwdInput,
			HttpSession session, Model model) throws IOException {
		try {
			String adminId = (String) session.getAttribute("adminId");
			if (oldPwdInput.equals(newPwdInput)) {
				model.addAttribute("errorMsg", "Old and new passwords cannot be the same. Please try again.");
			} else {
				Admin adminObj = adminRepository.findById(adminId);
				String oldPass = adminObj.getPwd();
				if (oldPass.equals(oldPwdInput)) {
					adminObj.setPwd(newPwdInput);
					adminRepository.updatePassword(adminObj);
					model.addAttribute("successMsg", "Password change successful.");
				} else {
					model.addAttribute("errorMsg",
							"Password change not successful. Please re-check the old password entered and try again.");
				}
			}
		} catch (Exception e) {
			logger.info("Exception occured at AdminLoginController" + e.getMessage());
			model.addAttribute("errorMsg",
					"Oops! Something went wrong. We regret the inconvenience caused. Request you to login and try again.");
			return "results";
		}
		return "results";

	}

}
