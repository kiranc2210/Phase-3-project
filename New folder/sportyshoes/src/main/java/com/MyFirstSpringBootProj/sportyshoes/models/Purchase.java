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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;  


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ApiModel(description = "All details about the User Purchase. ")
@Table(name = "PURCHASE_TBL")   
public class Purchase { 


	@Id 
	@ApiModelProperty(notes = "The database generated ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long ID;
	
	@ApiModelProperty(notes = "User ID")
	@Column(name = "user_id")
	private long userId;
	
	@ApiModelProperty(notes = "Date of Added")
	@Column(name = "date")
	private Date date;
	
	@ApiModelProperty(notes = "Total")
	@Column(name = "gross_total")
	private BigDecimal total;

	
	public long getID() {return this.ID; }
	public long getUserId() { return this.userId;}
	public BigDecimal getTotal() { return this.total;}
	public Date getDate() { return this.date;}
	
	public void setID(long id) { this.ID = id;}
	public void setUserId(long value) { this.userId = value;}
	public void setTotal(BigDecimal value) { this.total = value;}
	public void setDate(Date date) { this.date = date;}   
}
