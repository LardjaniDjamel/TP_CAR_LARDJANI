package com.example.shop.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.shop.entities.LigneCommande;
import com.example.shop.entities.Produit;
import com.example.shop.repository.LigneCommandeRepo;
import com.example.shop.service.Impl.ProduitServiceImpl;

@Controller
public class CartController {
	
	@Autowired
	ProduitServiceImpl produit  ;
	
	
	@Autowired
	LigneCommandeRepo lcommandeRepo ;
	
	List<Produit> liste =new ArrayList<Produit>();
	

	@GetMapping(value = "/cart/{id}/{idc}")
	public ModelAndView AddToCart(@PathVariable int id,@PathVariable int idc ) 
	{	
		System.out.println(id);
		System.out.println(idc);
		
		LigneCommande lc;
		Produit p=produit.getById(id);

		lc=new LigneCommande(id,idc,p.getPrice(),p.getQuantite());
		lcommandeRepo.save(lc);
		
		//liste.add(p);
		ModelAndView mav = new ModelAndView("redirect:/test");
		//mav.addObject("liste", liste);
		return mav;
	}
	
	@GetMapping(value = "/cart")
	public ModelAndView AfficheCart( ) 
	{	
		List<LigneCommande> list = new ArrayList<LigneCommande>();
		list=lcommandeRepo.findAll();
		List<Produit> liste = new ArrayList<Produit>();
		
		for (LigneCommande l :list) {
			liste.add(produit.getById(l.getId_produit()));
					
		}
		
		for (Produit p:liste) {
			System.out.println(p.getNom());
		}
				
		ModelAndView mav = new ModelAndView("cart");
		mav.addObject("liste", liste);
		return mav;
	}
	
	
	
	
	
	

}
