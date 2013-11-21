package com.lwz.android.viewholderadapter.sample;

import java.io.Serializable;

public class Lamp implements Serializable {

	private static final long serialVersionUID = -3396283637082655921L;
	
	private boolean turnon;
	private String type;
	
	public boolean isTurnon() {
		return turnon;
	}
	public void setTurnon(boolean turnon) {
		this.turnon = turnon;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
