package org.RestAssured.Pojo.Request_pojo_Restfull;


public class Auth {
	private String username;
	private String password;

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername()
	{
		return username;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getPassword(){
		return password;
	}
}