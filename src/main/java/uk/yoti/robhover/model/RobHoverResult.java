package uk.yoti.robhover.model;

public class RobHoverResult {
	
	public RobHoverResult(AreaPoint areapoint, Integer patches) {
		this.coords = areapoint;
		this.patches = patches;
	}
	AreaPoint coords;
	Integer patches;
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
	
	
	
	

}
