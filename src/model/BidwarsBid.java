package model;

import java.io.Serializable;
import javax.persistence.*;

import entities.BidwarsUser;

import java.util.Date;
import java.util.List;

public class BidwarsBid {
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BidwarsBid [id=" + id + ", amount=" + amount + ", bidTime=" + bidTime + ", bidwarsUsers=" + bidwarsUsers
				+ ", BidwarsProduct=" + BidwarsProduct + "]";
	}
	private Integer id;
	private Float amount;
	private Date bidTime;
	private List<BidwarsUser> bidwarsUsers;
	private List<BidwarsProduct> BidwarsProduct;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the amount
	 */
	public Float getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	/**
	 * @return the bidTime
	 */
	public Date getBidTime() {
		return bidTime;
	}
	/**
	 * @param bidTime the bidTime to set
	 */
	public void setBidTime(Date bidTime) {
		this.bidTime = bidTime;
	}
	/**
	 * @return the bidwarsUsers
	 */
	public List<BidwarsUser> getBidwarsUsers() {
		return bidwarsUsers;
	}
	/**
	 * @param bidwarsUsers the bidwarsUsers to set
	 */
	public void setBidwarsUsers(List<BidwarsUser> bidwarsUsers) {
		this.bidwarsUsers = bidwarsUsers;
	}
	/**
	 * @return the bidwarsProduct
	 */
	public List<BidwarsProduct> getBidwarsProduct() {
		return BidwarsProduct;
	}
	/**
	 * @param bidwarsProduct the bidwarsProduct to set
	 */
	public void setBidwarsProduct(List<BidwarsProduct> bidwarsProduct) {
		BidwarsProduct = bidwarsProduct;
	}
	
}
