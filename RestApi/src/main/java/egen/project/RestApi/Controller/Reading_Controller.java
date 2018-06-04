package egen.project.RestApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import egen.project.RestApi.entity.Readings;
import egen.project.RestApi.service.Alert_Service_layer;
import egen.project.RestApi.service.Reading_Service_layer;
import egen.project.RestApi.service.Vehicle_Service_layer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController

@CrossOrigin("*")
@Api(description = "Readings related endpoints")
public class Reading_Controller {
	@Autowired
	private Reading_Service_layer reading_service;
	
	// Saving the all the reading for the vehicles
		@PostMapping("/readings")
		@ApiOperation(value = "Save the readings of vehicles")
		public void saveReadings(@RequestBody Readings reading)
		{
			reading_service.saveReadings(reading);

		}
		
		// Return the geo-locations of particular vehicle
		@GetMapping("/locations/{vehiclenumber}")
		@ApiOperation(value = "Return the geolocation of vehicle for the specified vehicle number")
		public List<Object[]> getGeoLocatios(@PathVariable String vehiclenumber){
			
			List<Object[]> geolocations = reading_service.getGeoLoation(vehiclenumber);
			
			return geolocations;
			
		}
}
