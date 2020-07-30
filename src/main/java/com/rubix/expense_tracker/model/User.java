package com.rubix.expense_tracker.model;


import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import javax.persistence.CascadeType;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



/*
 * Returns the user object to the controller
 * the user objects are connected to mySql database using @Entity */

/**
 * @author PC 2
 *
 */
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
@Entity
@Table(name = "user",catalog="map")
public class User   {

	

	@Id
  @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String mobile;
	private String status;
	
	
	
	 @ManyToMany(targetEntity = UserType.class, cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH} )
	    
		   private List < UserType > usertype;
	//@JsonManagedReference
	    
	
	/**
	 * @return the expense
	 */
	//public List<Expense> getExpense() {
	//return expense;
	//}

	/**
	 * @return the usertype
	 */
	public List<UserType> getUsertype() {
		return usertype;
	}

	/**
	 * @param usertype the usertype to set
	 */
	public void setUsertype(List<UserType> usertype) {
		this.usertype = usertype;
	}

	/**
	 * @param expense the expense to set
	 */
	//public void setExpense(List<Expense> expense) {
	//	this.expense = expense;
	//}

	public User() {

	}

	/**
	 * @param id
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param mobile
	 * @param ssn
	 * @param status
	 */
	public User(int id,  String firstname, String lastname, String email, String mobile,String status) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.mobile = mobile;
		this.status=status;
		
		
		
	}
	
	

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	


	/**
	 * @return the firstname
	 */
	@Column(name = "firstname", nullable = false)
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	
	/**
	 * @return the lastname
	 */
	@Column(name = "lastname", nullable = false)
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	
	/**
	 * @return the email
	 */
	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	/**
	 * @return the mobile
	 */
	@Column(name = "mobile", nullable = false)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	

	/**
	 * @return the status
	 */
	@Column(name = "status", nullable = false)
	  public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 *
	 */
	@Override public String toString() { 
		  return "User [id=" + id + ", firstname="
			  	+ firstname + ", lastname=" + lastname + ", email=" + email +
	   ",status="+status+"]"; }

}