package com.simplilearn.kitchenstory.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AddNewProductController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/addnewproduct", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public String addNewProduct(@RequestParam("product_image") MultipartFile multipartFile,
			@RequestParam("product_name") String product_name, @RequestParam("product_id") String product_id,
			@RequestParam("product_stock") int product_stock, @RequestParam("product_price") int product_price,
			Model model) throws IOException {

		try {
			// Read data file
			FileReader reader = new FileReader("src/main/resources/data.json");
			JSONParser jsonParser = new JSONParser();
			Object obj = jsonParser.parse(reader);

			JSONArray productsList = (JSONArray) obj;
			// Check if product with same ID already exists
			JSONObject jsonObject;
			if (productsList != null) {
				int len = productsList.size();
				for (int i = 0; i < len; i++) {
					jsonObject = (JSONObject) productsList.get(i);
					if (jsonObject.get("_id").equals(product_id)) {
						model.addAttribute("errorMsg", "Product with same ID already exists. Please try again.");
						return "results";
					}
				}
			}

			String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
			// Check if product with same image name already exists
			File f = new File("src/main/resources/static/images/" + fileName);
			if (f.exists() && !f.isDirectory()) {
				model.addAttribute("errorMsg", "Product with same image name already exists. Please try again.");
				return "results";
			}

			// Create image file
			File imageFile = new File("src/main/resources/static/images/" + fileName);
			imageFile.createNewFile();
			FileOutputStream fout = new FileOutputStream(imageFile);
			fout.write(multipartFile.getBytes());
			fout.close();

			String imagePath = "./images/" + fileName;

			JSONObject objJsonObject = new JSONObject();
			objJsonObject.put("product_image_sm", imagePath);
			objJsonObject.put("product_image_md", imagePath);
			objJsonObject.put("product_image_lg", imagePath);
			objJsonObject.put("_id", product_id);
			objJsonObject.put("product_name", product_name);
			objJsonObject.put("product_stock", product_stock);
			objJsonObject.put("product_price", product_stock);

			productsList.add(objJsonObject);

			// Write new JSON object to file
			FileWriter filewriter = new FileWriter("src/main/resources/data.json");
			filewriter.write(productsList.toJSONString());
			filewriter.close();

			model.addAttribute("successMsg", "Product added successfully.");
			return "results";

		} catch (Exception e) {
			logger.info("Exception occured at AddNewProductController -> {}" + e.getMessage());
			model.addAttribute("errorMsg", "Oops! Something went wrong. Please try again later.");
			return "results";
		}
	}

}
