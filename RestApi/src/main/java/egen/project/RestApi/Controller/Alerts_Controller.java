package egen.project.RestApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import egen.project.RestApi.Exceptions.AlertsNotFoundException;
import egen.project.RestApi.entity.Alerts;
import egen.project.RestApi.service.Alert_Service_layer;
import egen.project.RestApi.service.Vehicle_Service_layer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController

@CrossOrigin("*")
@Api(description = "Alerts related endpoints")
public class Alerts_Controller {

	@Autowired
	private Alert_Service_layer alert_service;
	
	// Return the all the high alerts in the last 2 hours 
		@GetMapping("/alerts")
		@ApiOperation(value = "Return the List of all high alerts for the last 2 hours")
		public List<Alerts> getAllHighAlerts() throws AlertsNotFoundException
		{
			List<Alerts> alerts = alert_service.getAllHighAlerts();
			return alerts;
		}
		

		
		// Return the alerts of specified vehicle in the last 30 minutes
		@GetMapping("/alerts/{vehiclenumber}")
		@ApiOperation(value = "Return the alerts of vehicle for the specified vehicle number in last 30 minutes")
		public List<Alerts> getAllAlerts(@PathVariable String vehiclenumber)
		{
			List<Alerts> alerts = alert_service.getAllAlerts(vehiclenumber);
			
			return alerts;
		}
}
