package com.simplilearn.kitchenstory.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FetchProductsData {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/fetchdata", method = RequestMethod.GET)
	public String fetchJsonData() throws IOException {
		try {
			File resource = new ClassPathResource("data.json").getFile();
			String text = new String(Files.readAllBytes(resource.toPath()));
			return text;
		} catch (Exception e) {
			logger.info("Exception occured at ReadJsonData" + e.getMessage());
			return "{}";
		}
	}
}
