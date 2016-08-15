package entities;


import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(BidwarsCategory.class)
public class BidwarsCategory_ {
	public static volatile SingularAttribute<BidwarsCategory, Integer> id;
	public static volatile SingularAttribute<BidwarsCategory, String> name;
	public static volatile SingularAttribute<BidwarsCategory, String> description;

}
