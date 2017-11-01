package uk.goji.techtest;

import java.security.InvalidParameterException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import uk.yoti.robhover.WebApplication;
import uk.yoti.robhover.model.AreaPoint;
import uk.yoti.robhover.service.RobHover;



@RunWith(SpringRunner.class)
@SpringBootTest(  classes = WebApplication.class)
public class RobHoverTest {
	
	@Autowired
	private  RobHover robHoverService; 
	
	
	@Test(expected = InvalidParameterException.class)
   public final void testWhenInvalidRoomSize() {
		System.out.println("running testWhenInvalidRoomSize(..)");
		robHoverService.startRobot(null, new AreaPoint(1,2),null, null);
	}
	
	@Test(expected = InvalidParameterException.class)
   public  void testWhenInvalidStartPoint() {
		System.out.println("running testWhenInvalidStartPoint(..)");
		robHoverService.startRobot(null, null,null, null);

	}
	
	
	@Test(expected = InvalidParameterException.class)
   public  void testWhenInvalidPatches() {
		System.out.println("running testWhenInvalidPatches(..)");
		robHoverService.startRobot(null, null,null, null);


	}
	
	@Test(expected = InvalidParameterException.class)
   public  void testWhenInvalidInstruction() {
		System.out.println("running testWhenInvalidInstruction(..)");
		robHoverService.startRobot(null, null,null, null);

	}
	
//	@Test
//   public final void testoK() {
//		System.out.println("running testoK(..)");
//
//	}
	
	
}
