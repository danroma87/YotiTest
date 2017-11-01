package uk.yoti.robhover.service;


import uk.yoti.robhover.model.AreaPoint;
import uk.yoti.robhover.model.RobHoverResult;

public interface RobHover {
	public RobHoverResult startRobot(AreaPoint roomSize, AreaPoint startPoint, AreaPoint[] patches, String instructions );
}
