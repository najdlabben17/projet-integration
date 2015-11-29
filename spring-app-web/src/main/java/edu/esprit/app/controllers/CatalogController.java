package edu.esprit.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.esprit.app.entities.Product;
import edu.esprit.app.service.ICatalogService;

@Controller
public class CatalogController {

	@Autowired
	private ICatalogService catalogService;

	public ICatalogService getCatalogService() {
		return catalogService;
	}

	public void setCatalogService(ICatalogService catalogService) {
		this.catalogService = catalogService;
	}

	@RequestMapping(value = "/index")
	public String loadHomePage(Model model){
		
		model.addAttribute("product", new Product());
		model.addAttribute("products", catalogService.findAllProducts());
		return "home";
		
	}
	
	@RequestMapping(value = "/save")
	public String addProduct(@Valid Product product, BindingResult br,  Model model){
		
		if(br.hasErrors()) {
		
			model.addAttribute("products", catalogService.findAllProducts());
			return "home";
		}
		
		//Use merge to save or update
		catalogService.updtaeProduct(product);
		model.addAttribute("product", new Product());
		model.addAttribute("products", catalogService.findAllProducts());
		return "home";
	}

	@RequestMapping(value = "/selectForUpdate")
	public String selectForUpdate(@RequestParam("selectedProd") String prodRef, Model model){

		model.addAttribute("product", catalogService.findProductBySerialNumber(prodRef));
		model.addAttribute("products", catalogService.findAllProducts());
		return "home";
	}
	
	@RequestMapping(value = "/delete")
	public String deleteProduct(@RequestParam("selectedProd") String prodRef, Model model){

		catalogService.deleteProduct(prodRef);
		model.addAttribute("product", new Product());
		model.addAttribute("products", catalogService.findAllProducts());
		return "home";
	}
		


}
