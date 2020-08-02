package com.MyFirstSpringBootProj.sportyshoes.models;


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
@ApiModel(description = "All details about the category. ")
@Table(name = "CATEGORY_TBL") 
public class Category { 


	@Id 
	@ApiModelProperty(notes = "The database generated ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long ID;
	
	@ApiModelProperty(notes = "Category Name")
	@Column(name = "name")
	private String name;
	
	
	public long getID() {return this.ID; }
	public String getName() { return this.name;}
	
	public void setID(long id) { this.ID = id;}
	public void setName(String value) { this.name = value;}
	
}
