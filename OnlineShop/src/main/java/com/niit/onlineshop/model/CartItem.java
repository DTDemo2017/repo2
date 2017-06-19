package com.niit.onlineshop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class CartItem implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cartItemId;
	private double subTotal;
	@OneToOne
	@JoinColumn(name="productId")
	Product product;

	@ManyToOne
	@JoinColumn(name="cartId")
	Cart cart;
	private int quantity;
	
	private String status;
	
	public int getCartItemId() {
		return cartItemId;
	}
	
	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}
	
	public double getSubTotal() {
		return subTotal;
	}
	
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Cart getCart() {
		return cart;
	}
	
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
		
	}
	

}
