package com.itask.app.main.dao;

public class SearchParam {
	private String query;
	private int startRow;
	private int endRow;

	public SearchParam(String query, int startRow, int endRow) {
		this.query = query;
		this.startRow = startRow;
		this.endRow = endRow;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public String getQuery() {
		return query;
	}

	public int getStartRow() {
		return startRow;
	}

	public int getEndRow() {
		return endRow;
	}
}
