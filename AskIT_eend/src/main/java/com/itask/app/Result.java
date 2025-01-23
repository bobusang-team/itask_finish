package com.itask.app;

public class Result {
	private String path;
	private boolean isRedirect;
	
	//constructor
	public Result() {
		super();
	}

	//setter, getter
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	
}

