package com.rubix.expense_tracker.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "expense" ,   catalog="map")
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
    private String quantity;
	private String tax;
	private String price;
	private String amount;
	private String total;
	private Date purchase_date;
	private String created_by;
	private String updated_by;
	

	 @OneToMany(mappedBy = "expense",  cascade = CascadeType.REMOVE)
		   private List < Currency > currency;
	 
	
	

	public Expense() {
		
	}
	
	public Expense(String name, String quantity, String tax,String price,String amount,String total,Date purchase_date,String created_by,String updated_by) {
		
		this.name = name;
	    this.quantity = quantity;
		this.tax = tax;
		this.price = price;
		this.amount = amount;
		this.total = total;
		this.purchase_date = purchase_date;
		this.created_by = created_by;
		this.updated_by = updated_by;
		
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name = "name", nullable = false)
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	@Column(name = "quantity", nullable = false)
	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	@Column(name = "tax", nullable = false)
	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}
	@Column(name = "price", nullable = false)
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	@Column(name = "amount", nullable = false)
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	@Column(name = "total", nullable = false)
	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
	@Column(name = "purchase_date", nullable = false)
	public Date getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
	}
	@Column(name = "created_by", nullable = false)
	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	@Column(name = "updated_by", nullable = false)
	public String getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}

	

	@Override
	public String toString() {
		return "Expense [id=" + id + ",name =" + name+ ",quantity=" + quantity + ",tax=" +tax + ",price= " + price + ",amount =" +amount + ", total = "+ total + ",purchase_date =" + purchase_date +",created_by =" +created_by +", updated_by = " +  updated_by  
				+ "]";
	}
	
}