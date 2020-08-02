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
@ApiModel(description = "All details about the Admin. ")
@Table(name = "ADMIN_TBL") 
public class Admin { 


	@Id 
	@ApiModelProperty(notes = "The database generated ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long ID;
	
	@ApiModelProperty(notes = "Admin Id")
	@Column(name = "admin_id")
	private String adminId;
	
	@ApiModelProperty(notes = "Admin Password")
	@Column(name = "admin_pwd")
	private String pwd;
	
	
	public long getID() {return this.ID; }
	public String getAdminId() { return this.adminId;}
	public String getAdminPwd() { return this.pwd;}
	
	public void setID(long id) { this.ID = id;}
	public void setAdminId(String value) { this.adminId= value;}
	public void setAdminPwd(String value) { this.pwd = value;}
}
