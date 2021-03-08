package com.example.shop.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.shop.entities.Produit;
import com.example.shop.repository.ProduitRepo;
import com.example.shop.service.Impl.ProduitServiceImpl;

@Controller
@ResponseBody
public class ProduitController {
	
	@Autowired
	ProduitServiceImpl produit  ;
	
	@GetMapping("/test")
	@ResponseBody
	public ModelAndView test(ModelMap pModel) {

		ModelAndView mav = new ModelAndView("cart");
	
        return mav;
	}
	
	

	
	@GetMapping("/home")
	@ResponseBody
	public ModelAndView index(ModelMap pModel) {
		List<Produit> liste = new ArrayList<Produit>();

		liste=produit.getAllProduit();
	
		ModelAndView mav = new ModelAndView("test");
		mav.addObject("liste",liste);
        return mav;
	}
	

	
	@GetMapping("/product")
	@ResponseBody
	public ModelAndView prod(ModelMap pModel) {
		List<Produit> liste = new ArrayList<Produit>();
		liste=produit.getAllProduit();
		ModelAndView mav = new ModelAndView("product");
		//mav.addObject("liste",liste);
        return mav;
	}
	
	
	

}
