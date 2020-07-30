package com.rubix.expense_tracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.ManyToMany;
import java.util.List;
import javax.persistence.CascadeType;

@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")

@Entity

@Table(name = "usertype",catalog="map")

public class UserType  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "name", nullable = false)
	private String name;
	//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	//@ManyToOne(cascade = CascadeType.ALL)
	 @ManyToMany(targetEntity = User.class, mappedBy = "usertype", cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	
	private List<User> user;
	//@JsonBackReference


	



	public UserType() {
		
	}
	
	

	/**
	 * @return the user
	 */
	public List<User> getUser() {
		return user;
	}



	/**
	 * @param user the user to set
	 */
	public void setUser(List<User> user) {
		this.user = user;
	}



	public UserType(int id, String name) {
		super();
		this.id=id;
	
		this.name = name;
	}
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}



	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override public String toString() { 
		  return "UserType [id="+id+ ", name="
			  	+ name + "]"; }



}
