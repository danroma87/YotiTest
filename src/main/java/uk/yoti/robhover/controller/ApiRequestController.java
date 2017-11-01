package uk.yoti.robhover.controller;

import java.util.HashMap;
import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import uk.yoti.robhover.model.AreaPoint;
import uk.yoti.robhover.model.RobHoverResult;
import uk.yoti.robhover.service.RobHover;


@RestController
@EnableAutoConfiguration
public class ApiRequestController {

    @Autowired
    private RobHover robHoverService;

    private static final Logger logger = LoggerFactory.getLogger(ApiRequestController.class);

    

    
    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    public @ResponseBody ApiResponse confirm( @RequestBody ApiRequest payload) {
       logger.info("Api request received "+payload.toString());
       ApiResponse response = null;
       try {

     	  
     	  RobHoverResult result = robHoverService.startRobot(payload.getRoomSize(), payload.getCoords(), payload.getPatches(), payload.getInstructions());
     	   response = new ApiResponse(result.getCoords(),result.getPatches(), "success");
       } catch (Exception e) {
           logger.error("Error occurred while trying to process api request", e);
           response = new ApiResponse("fail");
       }

       
       return response;
    }

    @RequestMapping(value = "/getjsonexample", method = RequestMethod.POST)
    public @ResponseBody ApiRequest getExample() {
   	 logger.info("Example requested on POST");
   	 ApiRequest req = new ApiRequest();
   	 req.setCoords(new AreaPoint(2, 2));
   	 
   	 req.setRoomSize(new AreaPoint(5, 5));
   	 AreaPoint[] patches = new AreaPoint[2];
   	 patches[0] = new AreaPoint(2, 2);
   	 patches[1] = new AreaPoint(3, 4);
   	 req.setPatches(patches);
   	 System.out.println("");
   	 
   	 return req;
    }

    

}
