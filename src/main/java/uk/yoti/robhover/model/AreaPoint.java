package uk.yoti.robhover.model;

public class AreaPoint {
	private Integer x,y;
	 
	public AreaPoint() {}
	public AreaPoint(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object p) {
		boolean ret = false;
		AreaPoint toCheck = (AreaPoint)p;
		if (this.getX() - toCheck.getX() == 0 && this.getY() - toCheck.getY() == 0) {
			ret = true;
		}
		
		return ret;
	}
	@Override
	public String toString() {
		return "AreaPoint [x=" + x + ", y=" + y + "]";
	}
	
	
	
	
}
