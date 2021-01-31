package com.caregiverproject.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.caregiverproject.entity.Caregiver;
import com.caregiverproject.entity.CaregiverSelector;
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
	
	@GetMapping("/clientFormUpdate")
	public String updateClient(@RequestParam("clientId") int clientId, Model theModel) {
		//client form
		Client theClient = clientService.findById(clientId);
		theModel.addAttribute("client", theClient);
		
		//form object to be able to access the Caregiver in the dropdown list
		theModel.addAttribute("caregiverSelector", new CaregiverSelector());
		
		//list of caregivers that the client does not have (dropdown)
		theModel.addAttribute("listCaregiversToAdd", clientService.getRemainingCaregivers(clientId));

		
		return "forms/client-form";
	}
	
	@GetMapping("/deleteCaregiver")
	public String deleteCaregiver(RedirectAttributes redirectAttributes, @RequestParam("caregiverId") int caregiverId,
									@RequestParam("clientId") int clientId) {
		clientService.deleteCaregiverFromClient(caregiverId, clientId);
		
		redirectAttributes.addAttribute("clientId", clientId);
		return "redirect:/clients/clientFormUpdate";
	}
	
	@PostMapping("/saveNewCaregiver")
	public String saveNewCaregiver(RedirectAttributes redirectAttributes, @RequestParam("clientId") int clientId, 
										@ModelAttribute CaregiverSelector caregiverSelector, BindingResult bindingResult) {
		if(!bindingResult.hasErrors()) {
			Caregiver theCaregiver = caregiverSelector.getSelectedCaregiver();
			clientService.addCaregiverToClient(theCaregiver.getId(), clientId);
		}
		
		redirectAttributes.addAttribute("clientId", clientId);
		return "redirect:/clients/clientFormUpdate";
	}
}
