package uk.yoti.robhover.model;

public enum InstructionsEnum {
	NORTH('N'),
	SOUTH('S'),
	EAST('E'),
	WEST('W');

	InstructionsEnum(char value) {
		this.value = value;
	}
	char value;
	
	public char getValue() {
		return value;
	}

}
