package com.MyFirstSpringBootProj.sportyshoes.models;

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
@ApiModel(description = "All details about the User. ")
@Table(name = "USER_TBL")
public class Users {

	@Id
	@ApiModelProperty(notes = "The database generated user ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long ID;

	@ApiModelProperty(notes = "user First Name")
	@Column(name = "fname")
	private String fname;

	@ApiModelProperty(notes = "user Last Name")
	@Column(name = "lname")
	private String lname;

	@ApiModelProperty(notes = "user Address")
	@Column(name = "address")
	private String address;

	@ApiModelProperty(notes = "user Age")
	@Column(name = "age")
	private int age;

	@ApiModelProperty(notes = "user Added Date")
	@Column(name = "date_added")
	private Date dateAdded;

	@ApiModelProperty(notes = "user Email-ID")
	@Column(name = "emailid")
	private String emailId;

	@ApiModelProperty(notes = "user Password")
	@Column(name = "pwd")
	private String pwd;

	@Override
	public String toString() {
		return "Users [ID=" + ID + ", fname=" + fname + ", lname=" + lname + ", address=" + address + ", age=" + age
				+ ", dateAdded=" + dateAdded + ", emailId=" + emailId + ", pwd=" + pwd + "]";
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
