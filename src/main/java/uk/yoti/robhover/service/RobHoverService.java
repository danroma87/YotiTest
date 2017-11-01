package uk.yoti.robhover.service;

import java.security.InvalidParameterException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import uk.yoti.robhover.model.AreaPoint;
import uk.yoti.robhover.model.InstructionsEnum;
import uk.yoti.robhover.model.RobHoverResult;

@Service
public class RobHoverService implements RobHover {
   private static final Logger logger = LoggerFactory.getLogger(RobHoverService.class);



	@Override
	public RobHoverResult startRobot(AreaPoint roomSize, AreaPoint startPoint, AreaPoint[] patches, String instructions) {
		int patchesCleaned =0;
		
		validateParameters(roomSize,startPoint,patches,instructions);
		
		char[] instructionsArray = instructions.toCharArray();
		AreaPoint actualPosition = null;
		for (char c : instructionsArray) {
			actualPosition = moveRobot(c,startPoint);
			reAdjustRobotAfterWallImpact(actualPosition, roomSize);
			patchesCleaned = checkIfActualRobotPositionIsAPatchOfDirt(actualPosition, patchesCleaned,patches);

		}
		RobHoverResult result = new RobHoverResult(actualPosition, patchesCleaned);
			
		return result;
	}
	
	private void reAdjustRobotAfterWallImpact(AreaPoint actualPosition, AreaPoint roomSize) {
			if (actualPosition.getX() > roomSize.getX()) {
				actualPosition.setX(roomSize.getX());
			} else if (actualPosition.getX() < 0) {
				actualPosition.setX(0);
			}
			
			if (actualPosition.getY() > roomSize.getY()) {
				actualPosition.setY(roomSize.getY());
			} else if (actualPosition.getY() < 0) {
				actualPosition.setY(0);
			}
	}

	private int checkIfActualRobotPositionIsAPatchOfDirt(AreaPoint actualPosition, int patchesCleaned, AreaPoint[] patches) {
		for (AreaPoint p : patches) {
			if (actualPosition.equals(p)) {
				patchesCleaned++;
			}
		}
		return patchesCleaned;
	}

	private AreaPoint moveRobot(char c, AreaPoint startPoint) {
		if (InstructionsEnum.EAST.getValue() == c) {
			startPoint.setX(startPoint.getX()+1);
		} else if (InstructionsEnum.WEST.getValue() == c) {
			startPoint.setX(startPoint.getX()-1);
		} else if (InstructionsEnum.NORTH.getValue() == c) {
			startPoint.setY(startPoint.getY()+1);
		} else if (InstructionsEnum.SOUTH.getValue() == c) {
			startPoint.setY(startPoint.getY()-1);
		}
		
		return startPoint;
		
	}

	private void validateParameters(AreaPoint roomSize, AreaPoint startPoint, AreaPoint[] patches, String instructions) {
		String method ="validateParameters(...) - ";
				//can do better... 
				if (isValidAreaPoint(roomSize) && isValidAreaPoint(roomSize)  && isValidAreaPoint(patches[0]) && isValidAreaPoint(patches[0])) {
					if (isValidInstructions(instructions) ) {
						logger.info(method+"All Parameters are valid");
					}
				}		
	}

	private boolean isValidAreaPoint(AreaPoint point) {
		boolean ret = false;
		if (point ==  null) {
			throw new InvalidParameterException("AreaPoint is Null or  not valid.");	
		} else if(point.getX() < 0 || point.getY() < 0) {
			throw new InvalidParameterException("AreaPoint must be a positive integer coordinate.");
		} else if (point.getX() == null || point.getY() == null) {
			throw new InvalidParameterException("One of the point are not valid.");
		}
		return ret;
	}

	
	private boolean isValidInstructions(String instruction) {
		boolean ret = false;
		if (null == instruction || "".equals(instruction)) {
			throw new InvalidParameterException("No valid instruction");	
		} else {
			ret = true;
		}
		
		return ret;
	}
}