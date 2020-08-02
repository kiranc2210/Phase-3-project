package com.MyFirstSpringBootProj.sportyshoes.models;

import java.math.BigDecimal;
import java.util.Date;

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
@ApiModel(description = "All details about the Products. ")
@Table(name = "PRODUCT_TBL")
public class Product {

	@Id
	@ApiModelProperty(notes = "The database generated ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long ID;

	@ApiModelProperty(notes = "Product Name")
	@Column(name = "name")
	private String name;

	@ApiModelProperty(notes = "Product Price")
	@Column(name = "price")
	private BigDecimal price;

	@ApiModelProperty(notes = "Product Added Date")
	@Column(name = "date_added")
	private Date dateAdded;

	@ApiModelProperty(notes = "Product Category ID")
	@Column(name = "category_id")
	private long categoryId;

	public long getID() {
		return this.ID;
	}

	public String getName() {
		return this.name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public long getCategoryId() {
		return this.categoryId;
	}

	public Date getDateAdded() {
		return this.dateAdded;
	}

	public void setID(long id) {
		this.ID = id;
	}

	public void setName(String value) {
		this.name = value;
	}

	public void setPrice(BigDecimal value) {
		this.price = value;
	}

	public void setCategoryId(long value) {
		this.categoryId = value;
	}

	public void setDateAdded(Date date) {
		this.dateAdded = date;
	}
}
