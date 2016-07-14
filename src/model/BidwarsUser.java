package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


public class BidwarsUser{
	 @Override
		public String toString() {
			return "BidwarsUser [ID=" + ID + ", user_key=" + userKey + ", username=" + username + ", password=" + password
					+ ", email=" + email + ", name=" + name + ", surname=" + surname + ", phone=" + phone + ", address="
					+ address + ", country=" + country + ", city=" + city + ", region=" + region + ", zipcode=" + zipcode
					+ ", vat=" + vat + ", user_group=" + user_group + ", sign_up_date=" + signUpDate + ", rating="
					+ rating + ", aproved=" + aproved + "]";
	 }
	private Integer ID;
    private String userKey;
	private String username;
	private String password;
	private String email;
	private String name;
    private String surname;
    private String phone;
    private String address;
    private String country;
    private String city;
    private String region;
    private String zipcode;
    private String vat;
    private Integer user_group;
    private Date signUpDate;
    private Integer rating;
    private Integer aproved;
    
    

    public BidwarsUser() {
    }



	public Integer getID() {
		return ID;
	}



	public void setID(Integer iD) {
		ID = iD;
	}



	public String getUser_key() {
		return userKey;
	}



	public void setUser_key(String user_key) {
		this.userKey = user_key;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSurname() {
		return surname;
	}



	public void setSurname(String surname) {
		this.surname = surname;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getRegion() {
		return region;
	}



	public void setRegion(String region) {
		this.region = region;
	}



	public String getZipcode() {
		return zipcode;
	}



	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}



	public String getVat() {
		return vat;
	}



	public void setVat(String vat) {
		this.vat = vat;
	}



	public Integer getUser_group() {
		return user_group;
	}



	public void setUser_group(Integer user_group) {
		this.user_group = user_group;
	}



	public Date getSign_up_date() {
		return signUpDate;
	}



	public void setSign_up_date(Date signUpDate) {
		this.signUpDate = signUpDate;
	}



	public Integer getRating() {
		return rating;
	}



	public void setRating(Integer rating) {
		this.rating = rating;
	}



	public Integer getAproved() {
		return aproved;
	}



	public void setAproved(Integer aproved) {
		this.aproved = aproved;
	}
    
}