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
	
	@GetMapping("/login")
	@ResponseBody

	public ModelAndView index(ModelMap pModel) {
		List<Produit> liste = new ArrayList<Produit>();
//		Client t = Crepo.findAll();
		
		//Client c = new Client(4,"djamel" ,"lard","1 rue","s@gmail","0566","sgdh");
		//Crepo.save(c);
		liste=produit.getAllProduit();
		//Produit p =produit.getById(2);
		//System.out.println(p.getIdProduit());
		//Produit p= new Produit (1, "hp", 650, 4, "Gamer", "hp.png");
		//produit.saveProduit(p);
		ModelAndView mav = new ModelAndView("test");
		mav.addObject("liste",liste);
		//pModel.addAttribute("liste", liste);
        return mav;
	}
	
	@GetMapping("/login")
	@ResponseBody
	public ModelAndView login(ModelMap pModel) {
		List<Produit> liste = new ArrayList<Produit>();
//		
		liste=produit.getAllProduit();
		//Produit p =produit.getById(2);
		//System.out.println(p.getIdProduit());
		//Produit p= new Produit (1, "hp", 650, 4, "Gamer", "hp.png");
		//produit.saveProduit(p);
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("liste",liste);
		//pModel.addAttribute("liste", liste);
        return mav;
	}
	
	

}
