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
@ApiModel(description = "Error response model")
public class ErrorResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Error Code", name = "code", value = "200")
	private int code;
	@ApiModelProperty(notes = "Status", name = "message", value = "SUCCESS")
	private String status;
	@ApiModelProperty(notes = "message", name = "message", value = "INVALID FIELD")
	private String message;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
