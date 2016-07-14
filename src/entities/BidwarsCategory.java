package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bidwars_category database table.
 * 
 */
@Entity
@Table(name="bidwars_category")
@NamedQuery(name="BidwarsCategory.findAll", query="SELECT b FROM BidwarsCategory b")
public class BidwarsCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String description;

	private String name;

	//bi-directional many-to-many association to BidwarsProduct
	@ManyToMany
	@JoinTable(
		name="bidwars_product_category"
		, joinColumns={
			@JoinColumn(name="category_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="product_ID")
			}
		)
	private List<BidwarsProduct> bidwarsProducts;

	public BidwarsCategory() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BidwarsProduct> getBidwarsProducts() {
		return this.bidwarsProducts;
	}

	public void setBidwarsProducts(List<BidwarsProduct> bidwarsProducts) {
		this.bidwarsProducts = bidwarsProducts;
	}

}