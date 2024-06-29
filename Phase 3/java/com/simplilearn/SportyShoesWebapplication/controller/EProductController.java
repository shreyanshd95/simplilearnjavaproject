package com.simplilearn.SportyShoesWebapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simplilearn.SportyShoesWebapplication.model.EproductDAO;
import com.simplilearn.SportyShoesWebapplication.entity.EProduct;

@Controller
public class EProductController {
	
	
		
		@Autowired
		EproductDAO productDAO;
		
		@RequestMapping(value="/list-products", method=RequestMethod.GET)
		public String listAllProducts(ModelMap map) {
			List<EProduct> list = productDAO.getProducts();
			map.addAttribute("list",list);
			return "list-products";
		}
		
		@RequestMapping(value="/add-product", method=RequestMethod.GET)
		public String addProducts(ModelMap map) {
			EProduct eProduct = new EProduct();
			map.addAttribute("eProduct",eProduct);
			return "add-product";
		}
		
		@RequestMapping(value="/add-product", method=RequestMethod.POST)
		public String saveProduct(ModelMap map, @ModelAttribute("eProduct") EProduct eProduct) {
			productDAO.addProduct(eProduct);
			return "success";
		}


		@RequestMapping(value="/update-product", method=RequestMethod.GET)
		public String updateProducts(ModelMap map) {
			EProduct eProduct = new EProduct();
			map.addAttribute("eProduct",eProduct);
			return "update-product";
		}
		@RequestMapping(value="/update-product", method=RequestMethod.POST)
		public String updateProduct(ModelMap map, @ModelAttribute("eProduct") EProduct eProduct) {
			productDAO.updatesaveProduct(eProduct);
			return "update-product-success";
		}
		@RequestMapping(value="/delete-product", method=RequestMethod.GET)
		public String deleteProduct(ModelMap map) {
			EProduct eProduct = new EProduct();
		    map.addAttribute("eProduct",eProduct);
			return "delete-product";
		}
		@RequestMapping(value="/delete-product", method=RequestMethod.POST)
		public String deleteaProduct(ModelMap map, @ModelAttribute("eProduct") EProduct eProduct) {
			productDAO.deleteProduct(eProduct.getId());
			return "delete-product-success";
		}
		

}
