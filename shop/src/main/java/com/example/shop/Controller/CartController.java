package com.example.shop.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.example.shop.service.Impl.LigneCommandeServiceImpl;
import com.example.shop.service.Impl.ProduitServiceImpl;

@Controller
public class CartController {
	
	@Autowired
	ProduitServiceImpl produit  ;
	
	@Autowired
	LigneCommandeServiceImpl ligneService ;
	
	
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
		ModelAndView mav = new ModelAndView("redirect:/cart");
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
	
	@GetMapping(value = "/cart/dell/{id}")
	public ModelAndView DellFromCart(@PathVariable int id) 
	{	
		List<LigneCommande> liste=new ArrayList<LigneCommande>();
		liste=lcommandeRepo.findAll();
	
		for( LigneCommande c: liste) 
		{
			if(c.getId_produit()==id) {
				lcommandeRepo.delete(c);

			}			
		}		
		//liste.add(p);
		ModelAndView mav = new ModelAndView("redirect:/cart");
		//mav.addObject("liste", liste);
		return mav;
	}
	
	
	@GetMapping(value = "/Continue")
	public ModelAndView Continue() 
	{	
		
		ModelAndView mav = new ModelAndView("redirect:/home");
		//mav.addObject("liste", liste);
		return mav;
	}
	
	
	@GetMapping(value = "/checkout")
	public ModelAndView checkout() 
	{	
		
		ModelAndView mav = new ModelAndView("checkout");
		//mav.addObject("liste", liste);
		return mav;
	}
	
	
	
	
	
	
	

}
