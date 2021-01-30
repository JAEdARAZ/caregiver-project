package com.caregiverproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.caregiverproject.entity.Client;
import com.caregiverproject.service.ClientService;

@Controller
@RequestMapping("/clients")
public class ClientController {
	
	private ClientService clientService;
	
	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}
	
	@GetMapping("/clientForm")
	public String showClientForm(Model theModel) {
		theModel.addAttribute("client", new Client());
		
		return "forms/client-form";
	}
	
	@PostMapping("/save")
	public String saveClient(@ModelAttribute Client theClient) {
		clientService.save(theClient);
		
		return "redirect:/mainMenu";
	}
}
