package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the bidwars_user database table.
 * 
 */
@Entity
@Table(name="bidwars_user")
@NamedQuery(name="BidwarsUser.findAll", query="SELECT b FROM BidwarsUser b")
public class BidwarsUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String address;

	private int aproved;

	private String city;

	private String country;

	private String email;

	private String name;

	private String password;

	private String phone;

	private int rating;

	private String region;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="sign_up_date")
	private Date signUpDate;

	private String surname;

	@Column(name="user_key")
	private String userKey;

	private String username;

	private String vat;

	private String zipcode;

	//bi-directional many-to-one association to BidwarsBid
	@OneToMany(mappedBy="bidwarsUser")
	private List<BidwarsBid> bidwarsBids;

	//bi-directional many-to-one association to BidwarsProduct
	@OneToMany(mappedBy="bidwarsUser")
	private List<BidwarsProduct> bidwarsProducts;

	//bi-directional many-to-one association to BidwarsUserGroup
	
	private Integer BidwarsUserGroup;

	public BidwarsUser() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAproved() {
		return this.aproved;
	}

	public void setAproved(int aproved) {
		this.aproved = aproved;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getRating() {
		return this.rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Date getSignUpDate() {
		return this.signUpDate;
	}

	public void setSignUpDate(Date signUpDate) {
		this.signUpDate = signUpDate;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUserKey() {
		return this.userKey;
	}

	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getVat() {
		return this.vat;
	}

	public void setVat(String vat) {
		this.vat = vat;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public List<BidwarsBid> getBidwarsBids() {
		return this.bidwarsBids;
	}

	public void setBidwarsBids(List<BidwarsBid> bidwarsBids) {
		this.bidwarsBids = bidwarsBids;
	}

	public BidwarsBid addBidwarsBid(BidwarsBid bidwarsBid) {
		getBidwarsBids().add(bidwarsBid);
		bidwarsBid.setBidwarsUser(this);

		return bidwarsBid;
	}

	public BidwarsBid removeBidwarsBid(BidwarsBid bidwarsBid) {
		getBidwarsBids().remove(bidwarsBid);
		bidwarsBid.setBidwarsUser(null);

		return bidwarsBid;
	}

	public List<BidwarsProduct> getBidwarsProducts() {
		return this.bidwarsProducts;
	}

	public void setBidwarsProducts(List<BidwarsProduct> bidwarsProducts) {
		this.bidwarsProducts = bidwarsProducts;
	}

	public BidwarsProduct addBidwarsProduct(BidwarsProduct bidwarsProduct) {
		getBidwarsProducts().add(bidwarsProduct);
		bidwarsProduct.setBidwarsUser(this);

		return bidwarsProduct;
	}

	public BidwarsProduct removeBidwarsProduct(BidwarsProduct bidwarsProduct) {
		getBidwarsProducts().remove(bidwarsProduct);
		bidwarsProduct.setBidwarsUser(null);

		return bidwarsProduct;
	}

	public Integer getBidwarsUserGroup() {
		return this.BidwarsUserGroup;
	}

	public void setBidwarsUserGroup(Integer integer) {
		this.BidwarsUserGroup = integer;
	}

}