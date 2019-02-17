package com.flux.models;

public class Stats {

	private String state;
	private int total;
	private int matchedCount;
	private int unmatchedCount;

	Stats() {
	}

	public Stats(String state, int total, int matchedCount, int unmatchedCount) {
		super();
		this.state = state;
		this.total = total;
		this.matchedCount = matchedCount;
		this.unmatchedCount = unmatchedCount;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getMatchedCount() {
		return matchedCount;
	}

	public void setMatchedCount(int matchedCount) {
		this.matchedCount = matchedCount;
	}

	public int getUnmatchedcount() {
		return unmatchedCount;
	}

	public void setUnmatchedcount(int unmatchedcount) {
		this.unmatchedCount = unmatchedcount;
	}

}
