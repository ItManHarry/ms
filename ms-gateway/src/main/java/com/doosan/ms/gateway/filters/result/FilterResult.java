package com.doosan.ms.gateway.filters.result;
import java.io.Serializable;

public class FilterResult implements Serializable {

	private static final long serialVersionUID = -7196773410439546025L;
	private boolean flag;
	private String message;
	
	public FilterResult() {}
	
	public FilterResult(boolean flag, String message) {
		super();
		this.flag = flag;
		this.message = message;
	}
	
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}