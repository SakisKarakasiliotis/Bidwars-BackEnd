package entities;


import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import java.util.List;

@StaticMetamodel(BidwarsUserGroup.class)
public class BidwarsUserGroup_ {
	public static volatile SingularAttribute<BidwarsUserGroup, Integer> id;
	public static volatile SingularAttribute<BidwarsUserGroup, String>  description;
	public static volatile SingularAttribute<BidwarsUserGroup, String>  name;
	public static volatile SingularAttribute<BidwarsUserGroup, List<BidwarsUser>> bidwarsUsers;
}
