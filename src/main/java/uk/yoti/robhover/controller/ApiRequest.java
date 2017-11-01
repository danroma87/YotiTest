package uk.yoti.robhover.controller;

import java.util.Arrays;

import uk.yoti.robhover.model.AreaPoint;

public class ApiRequest {
	private AreaPoint roomSize,coords;
	private AreaPoint[] patches;
	private String instructions;
	public AreaPoint getRoomSize() {
		return roomSize;
	}
	public void setRoomSize(AreaPoint roomSize) {
		this.roomSize = roomSize;
	}
	public AreaPoint getCoords() {
		return coords;
	}
	public void setCoords(AreaPoint coords) {
		this.coords = coords;
	}
	public AreaPoint[] getPatches() {
		return patches;
	}
	public void setPatches(AreaPoint[] patches) {
		this.patches = patches;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coords == null) ? 0 : coords.hashCode());
		result = prime * result + ((instructions == null) ? 0 : instructions.hashCode());
		result = prime * result + Arrays.hashCode(patches);
		result = prime * result + ((roomSize == null) ? 0 : roomSize.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApiRequest other = (ApiRequest) obj;
		if (coords == null) {
			if (other.coords != null)
				return false;
		} else if (!coords.equals(other.coords))
			return false;
		if (instructions == null) {
			if (other.instructions != null)
				return false;
		} else if (!instructions.equals(other.instructions))
			return false;
		if (!Arrays.equals(patches, other.patches))
			return false;
		if (roomSize == null) {
			if (other.roomSize != null)
				return false;
		} else if (!roomSize.equals(other.roomSize))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ApiRequest [roomSize=" + roomSize + ", coords=" + coords + ", patches=" + Arrays.toString(patches) + ", instructions=" + instructions + "]";
	}

	
	
}
