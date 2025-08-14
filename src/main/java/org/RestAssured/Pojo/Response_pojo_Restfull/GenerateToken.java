package org.RestAssured.Pojo.Response_pojo_Restfull;

import java.io.Serializable;

public class GenerateToken implements Serializable {
	private String token;

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}
}