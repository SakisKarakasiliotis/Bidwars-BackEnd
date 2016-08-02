package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;
import java.util.List;

@Generated(value="Dali", date="2016-04-08T13:57:04.869+0300")
@StaticMetamodel(BidwarsBid.class)
public class BidwarsBid_ {
	public static volatile SingularAttribute<BidwarsUser, Integer> id;
	public static volatile SingularAttribute<BidwarsUser, Float> amount;
	public static volatile SingularAttribute<BidwarsUser, Date> bidTime;
	public static volatile SingularAttribute<BidwarsUser, List<BidwarsBid>> bidwarsBids;
	public static volatile SingularAttribute<BidwarsUser, List<BidwarsProduct>> bidwarsProduct;

}
