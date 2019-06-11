package com.Zomato_home;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Zomato.Pojo.Zoamto_Pojo;
import com.mobile_validation.EmailValidation;
import com.mobile_validation.Mobile_validation;

@Controller
public class Zomato_Home {
	
	@RequestMapping(value="/RegisterUser")
	public String saveUser (Zoamto_Pojo zomato,Model model){
		
		
		
		System.out.println("the entered valuse are "+zomato.getName()+""+zomato.getMail()+""+zomato.getMob()+" "+zomato.getPassward()
		+" "+zomato.getCity());
		
		//Mobile validation need to write here
		 
		 Mobile_validation mv =new  Mobile_validation();
		mv.isValid(zomato.getMob());
		if(mv.isValid(zomato.getMob())){
			System.out.println("the entered mobile number valid");
			System.out.println("The mobile number is " +zomato.getMob());
		}else{
			System.out.println("The entered value is in valid");
			System.out.println("the mobile number is "+zomato.getMob());
				
		}
		
		//email validation need to write her
		 EmailValidation EV=new EmailValidation();
		 EV.isValid(zomato.getMail());
		 if(EV.isValid(zomato.getMail())){
			 System.out.println("entered email valuse is VALID");
		 }else{
			 System.out.println("the entered email is INVALID");
			 			 
		 }
		
		System.out.println("the values above hibernate");
		//hybernate configuration write here//

		Configuration configure = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = configure.buildSessionFactory();
		Session sess = sf.openSession();
		sess.save(zomato);
		sess.beginTransaction().commit();
		sess.close();
		
		
			
	model.addAttribute("key1"," welcome to profile page");
	return"Login ";
	}
	
	
	

}
