package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;
import java.util.List;

@Generated(value="Dali", date="2016-04-08T13:57:04.869+0300")
@StaticMetamodel(BidwarsUser.class)
public class BidwarsUser_ {
	public static volatile SingularAttribute<BidwarsUser, String>  username;
	public static volatile SingularAttribute<BidwarsUser, Integer> id;
	public static volatile SingularAttribute<BidwarsUser, String>  name;
	public static volatile SingularAttribute<BidwarsUser, String>  surname;
	public static volatile SingularAttribute<BidwarsUser, String>  password;
	public static volatile SingularAttribute<BidwarsUser, String>  address;
	public static volatile SingularAttribute<BidwarsUser, Integer> aproved; 
	public static volatile SingularAttribute<BidwarsUser, String>  city;
	public static volatile SingularAttribute<BidwarsUser, String>  country;
	public static volatile SingularAttribute<BidwarsUser, String>  email;
	public static volatile SingularAttribute<BidwarsUser, String>  phone;
	public static volatile SingularAttribute<BidwarsUser, Integer> rating;
	public static volatile SingularAttribute<BidwarsUser, String>  region;
	public static volatile SingularAttribute<BidwarsUser, Date>    signUpDate;
	public static volatile SingularAttribute<BidwarsUser, String>  userKey;
	public static volatile SingularAttribute<BidwarsUser, String>  vat;
	public static volatile SingularAttribute<BidwarsUser, String>  zipcode;
	public static volatile SingularAttribute<BidwarsUser, List<BidwarsBid>> bidwarsBids;
	public static volatile SingularAttribute<BidwarsUser, List<BidwarsProduct>> bidwarsProducts;
	public static volatile SingularAttribute<BidwarsUser, BidwarsUserGroup> bidwarsUserGroup;
	
}
