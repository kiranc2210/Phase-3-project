package com.MyFirstSpringBootProj.sportyshoes.models;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;  


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ApiModel(description = "All details about the Purchase Items. ")
@Table(name = "PURCHASEITM_TBL")
public class PurchaseItem { 


	@Id 
	@ApiModelProperty(notes = "The database generated ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long ID;
	
	@ApiModelProperty(notes = "Purchase ID")
	@Column(name = "purchase_id")
	private long purchaseId;
	
	@ApiModelProperty(notes = " Product ID")
	@Column(name = "product_id")
	private long productId;

	@ApiModelProperty(notes = "user ID")
	@Column(name = "user_id")
	private long userId;

	@ApiModelProperty(notes = "ProductId")
	@Column(name = "rate")
	private BigDecimal rate;

	@ApiModelProperty(notes = "Purchase Quantity")
	@Column(name = "qty")
	private int qty;

	@ApiModelProperty(notes = "Product Price")
	@Column(name = "price")
	private BigDecimal price;

	
	public long getID() {return this.ID; }
	public long getPurchaseId() { return this.purchaseId;}
	public long getProductId() { return this.productId;}
	public long getUserId() { return this.userId;}
	public BigDecimal getRate() { return this.rate;}	
	public int getQty() { return this.qty;}	
	public BigDecimal getPrice() { return this.price;}
	
	public void setID(long id) { this.ID = id;}
	public void setPurchaseId(long value) { this.purchaseId = value;}
	public void setProductId(long value) { this.productId = value;}
	public void setUserId(long value) { this.userId = value;}
	public void setRate(BigDecimal value) { this.rate = value;}
	public void setQty(int value) { this.qty= value;}
	public void setPrice(BigDecimal value) { this.price= value;}
	
	

}
