/**
 * 
 */
package com.example;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author hp
 *
 */

@ApiModel(description ="Employee Model")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// for swagger documentation
	@ApiModelProperty(notes = "id of the employee", name = "id", required = true, value = "1111")
	private int id;
	@ApiModelProperty(notes = "name of the employee", name = "name", required = true, value = "Junaid")
	private String name;
	@ApiModelProperty(notes = "department of the employee", name = "department", required = true, value = "account")
	private String department;
	@ApiModelProperty(notes = "phonenumber of the employee", name = "phoneNumber", required = true, value = "2221222")
	private String phoneNumber;

	public Employee() {
		super();

	}

	public Employee(int id, String name, String department, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
