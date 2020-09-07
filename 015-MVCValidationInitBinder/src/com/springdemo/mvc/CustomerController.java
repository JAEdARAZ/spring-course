package com.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//pre-process EVERY STRING from data, trimming it --> that's how they will stay
	//string only withespaces, StringTrimmerEditor(true) --> the string is trimmed to null
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTE = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTE);
	}
	
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(
			@Valid @ModelAttribute("customer") Customer customer, 
			BindingResult bindingResult) {
		
		//it will show that in case there were whitespaces, they have been cleaned
		System.out.println("First name |" + customer.getFirstName() + "|");
		System.out.println("Last name |" + customer.getLastName() + "|");
		
		return bindingResult.hasErrors() ? "customer-form" : "customer-confirmation";
	}
	
}
