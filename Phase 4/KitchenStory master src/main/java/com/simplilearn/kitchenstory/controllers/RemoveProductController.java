package com.simplilearn.kitchenstory.controllers;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RemoveProductController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/removeproduct", method = RequestMethod.POST)
	public String removeProduct(@RequestParam("product_id") String product_id, Model model) throws IOException {
		try {
			FileReader reader = new FileReader("src/main/resources/data.json");
			JSONParser jsonParser = new JSONParser();
			Object obj = jsonParser.parse(reader);

			JSONArray productsList = (JSONArray) obj;
			int removalIndex = -1;

			JSONObject jsonObject;
			if (productsList != null) {
				int len = productsList.size();
				for (int i = 0; i < len; i++) {
					jsonObject = (JSONObject) productsList.get(i);
					if (jsonObject.get("_id").equals(product_id)) {
						removalIndex = i;
					}
				}
			}
			if (removalIndex != -1) {
				jsonObject = (JSONObject) productsList.get(removalIndex);
				String filenameWithPath = (String) jsonObject.get("product_image_md");
				String[] tokens = filenameWithPath.split("[\\\\|/]");
				String filename = tokens[tokens.length - 1];

				// Remove JSON data
				productsList.remove(removalIndex);
				FileWriter filew = new FileWriter("src/main/resources/data.json");
				filew.write(productsList.toJSONString());
				filew.close();

				// Remove asset
				Path fileToDeletePath = Paths.get("src/main/resources/static/images/" + filename);
				Files.delete(fileToDeletePath);
				model.addAttribute("successMsg", "Product removed successfully.");
			} else {
				// Return - Product not found
				model.addAttribute("errorMsg", "Product not found. Please try again.");
			}
		} catch (Exception e) {
			logger.info("Exception occured at RemoveProductController -> {}" + e.getMessage());
			model.addAttribute("errorMsg", "Oops! Something went wrong. Please try again later.");
		}
		return "results";
	}
}
