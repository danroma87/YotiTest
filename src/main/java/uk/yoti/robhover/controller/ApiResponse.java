package uk.yoti.robhover.controller;

import uk.yoti.robhover.model.AreaPoint;

public class ApiResponse {

	AreaPoint coords;
	Integer patches;
	String  message;
	public ApiResponse(AreaPoint coords2, Integer patches2, String message) {
		this.coords = coords2;
		this.patches = patches2;
		this.message = message;
	}
	
	public ApiResponse(String errorMessage) {
		this.message = errorMessage;
	}
	
	public AreaPoint getCoords() {
		return coords;
	}
	public void setCoords(AreaPoint coords) {
		this.coords = coords;
	}
	public Integer getPatches() {
		return patches;
	}
	public void setPatches(Integer patches) {
		this.patches = patches;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
