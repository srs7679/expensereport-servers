package com.rubix.expense_tracker.model;

import com.rubix.expense_tracker.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserModel {
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String mobile;
	private String status;
    private List<UserTypeModel> usertype;
    
    
    
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
	/**
	 * @return the firstname
	 */
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
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the usertype
	 */
	public List<UserTypeModel> getUsertype() {
		return usertype;
	}
	/**
	 * @param usertype the usertype to set
	 */
	public void setUsertype(List<UserTypeModel> usertype) {
		this.usertype = usertype;
	}
    
   
}

