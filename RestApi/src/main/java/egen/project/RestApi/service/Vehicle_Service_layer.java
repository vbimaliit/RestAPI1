package egen.project.RestApi.service;

import java.util.List;

import egen.project.RestApi.Exceptions.AlertsNotFoundException;
import egen.project.RestApi.entity.Alerts;

import egen.project.RestApi.entity.Readings;
import egen.project.RestApi.entity.Vehicle;


public interface Vehicle_Service_layer {
	
	public void saveOrUpdateVehicle(List<Vehicle> vehicle);
	public List<Vehicle> getAllVehicle();


}
