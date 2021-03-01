package com.example.shop;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.shop.entities.Client;
import com.example.shop.repository.ClientRepo;


@Controller
@ResponseBody
public class HelloController {
	@Autowired
	ClientRepo crepo;
	


	@GetMapping("/hello")
	public String index() {
		//List<Client> li = new ArrayList<Client>();
//		Client t = Crepo.findAll();
		
		//Client c = new Client(4,"djamel" ,"lard","1 rue","s@gmail","0566","sgdh");
		//Crepo.save(c);
		
		return "login";
	}
}
