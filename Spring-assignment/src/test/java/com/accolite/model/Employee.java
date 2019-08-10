package com.accolite.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity

@Table( name="employee" )
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Employee 
{
     @Id
     @GeneratedValue
	private int  eid;
	private int salary;
	private String ename;
	

}
