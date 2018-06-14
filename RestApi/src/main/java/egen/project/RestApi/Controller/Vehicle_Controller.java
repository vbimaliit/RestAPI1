package egen.project.RestApi.Controller;

import java.io.IOException;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import egen.project.RestApi.Exceptions.AlertsNotFoundException;
import egen.project.RestApi.entity.Alerts;

import egen.project.RestApi.entity.Readings;
import egen.project.RestApi.entity.Vehicle;
import egen.project.RestApi.service.Vehicle_Service_layer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController

@CrossOrigin("*")
@Api(description = "Vehicle related endpoints")
public class Vehicle_Controller {
	
	// Creating the object of service class
	@Autowired
	private Vehicle_Service_layer vehicle_service;
	
	
	
	
	// Saving the details of vehicles
	@PutMapping("/vehicles")
	@ApiOperation(value = "Save the details of vehicles")
	public void saveVehicle(@RequestBody List<Vehicle> vehicles)
	{
		vehicle_service.saveOrUpdateVehicle(vehicles);
	}
	
	
	// Returning the  list of all vehicles
	@GetMapping("/vehicles")
	@ApiOperation(value = "Return the List of all vehicles")
	public List<Vehicle> getAllVehicles()
	{
		List<Vehicle> vehicles = vehicle_service.getAllVehicle();
		return vehicles;
	}

	
		
		
		
		
		
	
}
