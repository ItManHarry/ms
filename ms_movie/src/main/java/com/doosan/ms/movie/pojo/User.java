package com.doosan.ms.movie.pojo;
import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = -3160369062939006798L;
	private Integer id;
	private String name;
	private String code;
	private String password;
	
	public User() {
		
	}
	
	public User(Integer id, String name, String code, String password) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
