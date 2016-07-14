package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the bidwars_bid database table.
 * 
 */
@Entity
@Table(name="bidwars_bid")
@NamedQuery(name="BidwarsBid.findAll", query="SELECT b FROM BidwarsBid b")
public class BidwarsBid implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private float amount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="bid_time")
	private Date bidTime;

	//bi-directional many-to-one association to BidwarsUser
	@ManyToOne
	@JoinColumn(name="bider_ID")
	private BidwarsUser bidwarsUser;

	//bi-directional many-to-one association to BidwarsProduct
	@ManyToOne
	@JoinColumn(name="product_ID")
	private BidwarsProduct bidwarsProduct;

	public BidwarsBid() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getAmount() {
		return this.amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Date getBidTime() {
		return this.bidTime;
	}

	public void setBidTime(Date bidTime) {
		this.bidTime = bidTime;
	}

	public BidwarsUser getBidwarsUser() {
		return this.bidwarsUser;
	}

	public void setBidwarsUser(BidwarsUser bidwarsUser) {
		this.bidwarsUser = bidwarsUser;
	}

	public BidwarsProduct getBidwarsProduct() {
		return this.bidwarsProduct;
	}

	public void setBidwarsProduct(BidwarsProduct bidwarsProduct) {
		this.bidwarsProduct = bidwarsProduct;
	}

}