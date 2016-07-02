package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the bidwars_product database table.
 * 
 */
@Entity
@Table(name="bidwars_product")
@NamedQuery(name="BidwarsProduct.findAll", query="SELECT b FROM BidwarsProduct b")
public class BidwarsProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="begin_date")
	private Date beginDate;

	private String country;

	@Column(name="current_price")
	private int currentPrice;

	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="`end-date`")
	private Date end_date;

	@Column(name="fisrt_bid")
	private int fisrtBid;

	private String location;

	private String name;

	@Column(name="number_of_bids")
	private int numberOfBids;

	private int rating;

	@Column(name="sold_to")
	private int soldTo;

	//bi-directional many-to-one association to BidwarsBid
	@OneToMany(mappedBy="bidwarsProduct")
	private List<BidwarsBid> bidwarsBids;

	//bi-directional many-to-one association to BidwarsUser
	@ManyToOne
	@JoinColumn(name="seller")
	private BidwarsUser bidwarsUser;

	//bi-directional many-to-many association to BidwarsCategory
	@ManyToMany(mappedBy="bidwarsProducts")
	private List<BidwarsCategory> bidwarsCategories;

	public BidwarsProduct() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBeginDate() {
		return this.beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getCurrentPrice() {
		return this.currentPrice;
	}

	public void setCurrentPrice(int currentPrice) {
		this.currentPrice = currentPrice;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEnd_date() {
		return this.end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public int getFisrtBid() {
		return this.fisrtBid;
	}

	public void setFisrtBid(int fisrtBid) {
		this.fisrtBid = fisrtBid;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfBids() {
		return this.numberOfBids;
	}

	public void setNumberOfBids(int numberOfBids) {
		this.numberOfBids = numberOfBids;
	}

	public int getRating() {
		return this.rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getSoldTo() {
		return this.soldTo;
	}

	public void setSoldTo(int soldTo) {
		this.soldTo = soldTo;
	}

	public List<BidwarsBid> getBidwarsBids() {
		return this.bidwarsBids;
	}

	public void setBidwarsBids(List<BidwarsBid> bidwarsBids) {
		this.bidwarsBids = bidwarsBids;
	}

	public BidwarsBid addBidwarsBid(BidwarsBid bidwarsBid) {
		getBidwarsBids().add(bidwarsBid);
		bidwarsBid.setBidwarsProduct(this);

		return bidwarsBid;
	}

	public BidwarsBid removeBidwarsBid(BidwarsBid bidwarsBid) {
		getBidwarsBids().remove(bidwarsBid);
		bidwarsBid.setBidwarsProduct(null);

		return bidwarsBid;
	}

	public BidwarsUser getBidwarsUser() {
		return this.bidwarsUser;
	}

	public void setBidwarsUser(BidwarsUser bidwarsUser) {
		this.bidwarsUser = bidwarsUser;
	}

	public List<BidwarsCategory> getBidwarsCategories() {
		return this.bidwarsCategories;
	}

	public void setBidwarsCategories(List<BidwarsCategory> bidwarsCategories) {
		this.bidwarsCategories = bidwarsCategories;
	}

}