package Dao;

public class User {
	private int id;
	private String name;
	private String password;
	private Double integral;
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Double getIntegral() {
		return integral;
	}
	public void setIntegral(Double integral) {
		this.integral = integral;
	}
	
	@Override
	public String toString() {
		return "id:"+id+" | "+"name:"+name+" | "+"password:"+password+" | "+"integral:"+integral;
	}
}