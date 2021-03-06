package com.ibm.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibm.dao.CustomerDao;
import com.ibm.model.Customer;
import com.ibm.repository.CustRepository;

@Controller
public class CustController {

	 @Autowired    
	 CustomerDao cdao;//will inject dao from XML file   
	 
	//ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
	//Customer custobj=(Customer) ctx.getBean("customer");
	//CustRepository custRepObj=(CustRepository) ctx.getBean("custRepository");
	
	
	
	
	@RequestMapping("/helloagain")  
	public String display()  
	{  
		System.out.print("display");
		 return "index";  
	}  

	@GetMapping(value= "/")
	public String getCustomers(ModelMap map)
	{
		List<Customer> list=cdao.getAllCustomers();
		System.out.println("\n inside getcustomers :"+list);
		map.put("custList",list);
		return "index";
	}
	@RequestMapping(value="/saveCustomer",method=RequestMethod.POST)
	public String addNewCustomer(@Validated @ModelAttribute("Customer")Customer customer,ModelMap map)
	{
		LocalDateTime dt=LocalDateTime.now();
		System.out.println("\n LocalDateTime:"+dt);
		customer.setCreatedAt(dt);
//		custRepObj.addCust(customer);
		
		List<Customer> list= cdao.getAllCustomers();
		System.out.println("\n inside addNewCustomer list :"+list);
    	map.put("custList",list);
		System.out.println("\n inside addNewCustomer:"+customer);
		cdao.saveCustomer(customer);
		return "index";	
	}
		@RequestMapping(value="/deleteCustomer",method=RequestMethod.GET)
		public String deleteCustomer(@RequestParam("custno") int custno)
		{
			//boolean del=custRepObj.deleteCustomer(custno);
			 cdao.deleteCustomer(custno);    
			return "redirect:/";
		}
//		@RequestMapping("/hello")  
//	    public String redirect()  
//	    {  
//	        return "viewpage";  
//	    }     
//	@RequestMapping("/helloagain")  
//	public String display()  
//	{  
//	    return "final";  
//	}  

}
