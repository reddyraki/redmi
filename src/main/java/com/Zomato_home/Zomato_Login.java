package com.Zomato_home;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Zomato.Pojo.Zoamto_Pojo;

@Controller
public class Zomato_Login {
	@RequestMapping(value="/LoginUser")
	public String loginUser(@RequestParam("mail") String mail,@RequestParam("pwd") String password ,Model m){
		System.out.println("the entered values are "+mail+" "+password);
		
		//need to write hibernate configuration here
		Configuration configure = new Configuration().configure();
		SessionFactory sf = configure.buildSessionFactory();
		Session sess = sf.openSession();
		Query query = sess.createQuery("from  Zoamto_Pojo where mail=:mailid and passward=:password");
		
		
		
		
		query.setParameter("mailid", mail);
		query.setParameter("password", password);
		List list = query.list();
		if(list.isEmpty()){
			System.out.println("the entered credentials is incorrect");
			return "login";
			
		}else{
			System.out.println("the entered credentials are correct");
			
			Query query2 = sess.createQuery(" from  Zoamto_Pojo");
			List<Zoamto_Pojo> list2 = query2.list();
			for (Zoamto_Pojo object : list2) {
				System.out.println(object.getName());
				System.out.println(object.getMail());
				System.out.println(object.getMob());
				System.out.println(object.getPassward());
				System.out.println(object.getCity());
			}
			m.addAttribute("key2", "welcome to PROFILE PAGE2");
			m.addAttribute("UserList",list2);
			return "Profile";
		}
		
	}

}


