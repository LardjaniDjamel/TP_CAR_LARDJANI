package com.example.shop.Controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.shop.entities.Client;
import com.example.shop.entities.Produit;
import com.example.shop.repository.ClientRepo;
import com.example.shop.service.Impl.ProduitServiceImpl;


@Controller
@ResponseBody
public class ClientController {
	
	@Autowired
	ClientRepo client  ;
	
	@Autowired
	ProduitServiceImpl produit  ;
	

	@GetMapping("/login")
	@ResponseBody
	public ModelAndView login(ModelMap pModel) {//		
		ModelAndView mav = new ModelAndView("login");
        return mav;
	}
	
	
	@PostMapping("/login")
	@ResponseBody
	public ModelAndView loginIn(@RequestParam(value = "email") String
			email,@RequestParam(value = "password") String pass) {
		
		List<Client> liste=new ArrayList<Client>();
		ModelAndView mav = null;
		liste=client.findAll();
		
		List<Produit> list = new ArrayList<Produit>();
		list=produit.getAllProduit();
		
		for( Client c : liste ) {
			if (((c.getEmail()).equals(email)) && (c.getMotDePasse()).equals(pass)) {
				
				mav = new ModelAndView("test");
				mav.addObject("liste",list);
			}
			else {
				mav = new ModelAndView("login");
				mav.addObject("erreur", "Incorrect email or password");

			}
			
		}
        return mav;
	}
	
	@GetMapping(value = "/addPerson")
	public ModelAndView addPerson() 
	{
		ModelAndView mav = new ModelAndView("inscription");
		return mav;
	}
	
	
	@PostMapping(value = "/addPerson")
	public ModelAndView inscription(@RequestParam(value = "nom") String
			nom,@RequestParam(value = "nom") String
			prenom,@RequestParam(value = "address") String address,@RequestParam(value = "email") String email,
			@RequestParam(value = "phone") String numero,@RequestParam(value = "password") String pass) 
	{
		Client c=new Client(nom,prenom,address,email,numero,pass);
		client.save(c);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("confirm");
		mv.addObject("nom", nom);
		mv.addObject("prenom", prenom);
		return mv;
		
	}
	
	@GetMapping(value = "/cart")
	public ModelAndView cart() 
	{
		ModelAndView mav = new ModelAndView("cart");
		return mav;
	}
	
	
	

	
	

}
