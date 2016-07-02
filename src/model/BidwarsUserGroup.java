package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bidwars_user_group database table.
 * 
 */
@Entity
@Table(name="bidwars_user_group")
@NamedQuery(name="BidwarsUserGroup.findAll", query="SELECT b FROM BidwarsUserGroup b")
public class BidwarsUserGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String description;

	private String name;

	//bi-directional many-to-one association to BidwarsUser
	@OneToMany(mappedBy="bidwarsUserGroup")
	private List<BidwarsUser> bidwarsUsers;

	public BidwarsUserGroup() {
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

	public List<BidwarsUser> getBidwarsUsers() {
		return this.bidwarsUsers;
	}

	public void setBidwarsUsers(List<BidwarsUser> bidwarsUsers) {
		this.bidwarsUsers = bidwarsUsers;
	}

	public BidwarsUser addBidwarsUser(BidwarsUser bidwarsUser) {
		getBidwarsUsers().add(bidwarsUser);
		bidwarsUser.setBidwarsUserGroup(this);

		return bidwarsUser;
	}

	public BidwarsUser removeBidwarsUser(BidwarsUser bidwarsUser) {
		getBidwarsUsers().remove(bidwarsUser);
		bidwarsUser.setBidwarsUserGroup(null);

		return bidwarsUser;
	}

}