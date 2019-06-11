package com.Zomato.Pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="zomato_spring")
public class Zoamto_Pojo {
	@Column(name="name")
	private String name;
	
	@Column(name="mail")
	private String mail;
	
	@Column(name="mobile")
	private String mob; 
	
	@Column(name="password")
	private String passward;
	
	@Column(name="city")
	private String city;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public String getPassward() {
		return passward;
	}
	public void setPassward(String passward) {
		this.passward = passward;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	

}
