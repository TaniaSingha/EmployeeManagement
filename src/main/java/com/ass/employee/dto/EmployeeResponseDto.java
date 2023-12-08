package com.ass.employee.dto;

import java.io.Serializable;

public class EmployeeResponseDto implements Serializable
{
	
	  private int statusCode;
	    private String status;
	    private String message;
	    private Object data;
		
	    
	    
	    public EmployeeResponseDto(int statusCode, String status, String message, Object data) 
	    {
			super();
			this.statusCode = statusCode;
			this.status = status;
			this.message = message;
			this.data = data;
		}



		public int getStatusCode() {
			return statusCode;
		}



		public void setStatusCode(int statusCode) {
			this.statusCode = statusCode;
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



		public Object getData() {
			return data;
		}



		public void setData(Object data) {
			this.data = data;
		}
	    
	    
	    
	    
	

}
