package model;


import java.io.Serializable;
import javax.persistence.*;

import entities.BidwarsUser;

import java.util.Date;
import java.util.List;


public class BidwarsUserGroup {
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BidwrasUserGroup [id=" + id + ", name=" + name + ", description=" + description + ", bidwarsUsers="
				+ bidwarsUsers + "]";
	}
	private Integer id;
	private String name;
	private String description;
	private List<BidwarsUser> bidwarsUsers;
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
	

}
