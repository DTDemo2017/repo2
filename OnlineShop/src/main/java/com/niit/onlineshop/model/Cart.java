package com.niit.onlineshop.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Cart implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cartId;
	private double Total;
	@OneToOne
	@JoinColumn(name="id")
	User user;
	
	@OneToMany(mappedBy="cart", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<CartItem> cartItems;
	
	

	/**
	 * @return the cartId
	 */
	public int getCartId() {
		return cartId;
	}

	/**
	 * @param cartId the cartId to set
	 */
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	/**
	 * @return the grandTotal
	 */
	public double getTotal() {
		return Total;
	}

	/**
	 * @param grandTotal the grandTotal to set
	 */
	public void setTotal(double Total) {
		this.Total = Total;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the cartItems
	 */
	public List<CartItem> getCartItems() {
		return cartItems;
	}

	/**
	 * @param cartItems the cartItems to set
	 */
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	
	
	
}
