package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class BidwarsProduct {
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BidwarsProduct [ID=" + ID + ", name=" + name + ", location=" + location + ", country=" + country
				+ ", begin_date=" + begin_date + ", end_date=" + end_date + ", rating=" + rating + ", seller=" + seller
				+ ", current_price=" + current_price + ", first_bid=" + first_bid + ", number_of_bids=" + number_of_bids
				+ ", description=" + description + ", sold_to=" + sold_to + "]";
	}
	private Integer ID;
	private String name;
	private String location;
	private String country;
	private Date begin_date;
	private Date end_date;
	private Integer rating;
	private Integer seller;
	private Integer current_price;
	private Integer first_bid;
	private Integer number_of_bids;
	private String description;
	private Integer sold_to;
	/**
	 * @return the iD
	 */
	public Integer getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(Integer iD) {
		ID = iD;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the begin_date
	 */
	public Date getBegin_date() {
		return begin_date;
	}
	/**
	 * @param begin_date the begin_date to set
	 */
	public void setBegin_date(Date begin_date) {
		this.begin_date = begin_date;
	}
	/**
	 * @return the end_date
	 */
	public Date getEnd_date() {
		return end_date;
	}
	/**
	 * @param end_date the end_date to set
	 */
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	/**
	 * @return the rating
	 */
	public Integer getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	/**
	 * @return the seller
	 */
	public Integer getSeller() {
		return seller;
	}
	/**
	 * @param seller the seller to set
	 */
	public void setSeller(Integer seller) {
		this.seller = seller;
	}
	/**
	 * @return the current_price
	 */
	public Integer getCurrent_price() {
		return current_price;
	}
	/**
	 * @param current_price the current_price to set
	 */
	public void setCurrent_price(Integer current_price) {
		this.current_price = current_price;
	}
	/**
	 * @return the first_bid
	 */
	public Integer getFirst_bid() {
		return first_bid;
	}
	/**
	 * @param first_bid the first_bid to set
	 */
	public void setFirst_bid(Integer first_bid) {
		this.first_bid = first_bid;
	}
	/**
	 * @return the number_of_bids
	 */
	public Integer getNumber_of_bids() {
		return number_of_bids;
	}
	/**
	 * @param number_of_bids the number_of_bids to set
	 */
	public void setNumber_of_bids(Integer number_of_bids) {
		this.number_of_bids = number_of_bids;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the sold_to
	 */
	public Integer getSold_to() {
		return sold_to;
	}
	/**
	 * @param sold_to the sold_to to set
	 */
	public void setSold_to(Integer sold_to) {
		this.sold_to = sold_to;
	}
}
