package entities;


import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;
import java.util.List;

@StaticMetamodel(BidwarsProduct.class)
public class BidwarsProduct_ {

	public static volatile SingularAttribute<BidwarsUser, Integer> id;
	public static volatile SingularAttribute<BidwarsUser, Date> beginDate;
	public static volatile SingularAttribute<BidwarsUser, String> country;
	public static volatile SingularAttribute<BidwarsUser, Integer> currentPrice; 
	public static volatile SingularAttribute<BidwarsUser, String> description;
	public static volatile SingularAttribute<BidwarsUser, Date>   end_date;
	public static volatile SingularAttribute<BidwarsUser, Integer> firstBid;
	public static volatile SingularAttribute<BidwarsUser, String>  location;
	public static volatile SingularAttribute<BidwarsUser, String>  name;
	public static volatile SingularAttribute<BidwarsUser, Integer> numberOfBids; 
	public static volatile SingularAttribute<BidwarsUser, Integer> rating;
	public static volatile SingularAttribute<BidwarsUser, Integer> soldTo;
	public static volatile SingularAttribute<BidwarsUser, List<BidwarsBid>> bidwarsBids; 
	public static volatile SingularAttribute<BidwarsUser, BidwarsUser> seller;
	public static volatile SingularAttribute<BidwarsUser, List<BidwarsCategory>> bidwarsCategories;
	
}
