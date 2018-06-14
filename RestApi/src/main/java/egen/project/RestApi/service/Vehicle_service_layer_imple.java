package egen.project.RestApi.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.net.SyslogOutputStream;
import egen.project.RestApi.Exceptions.AlertsNotFoundException;
import egen.project.RestApi.Exceptions.GeoLocationNotFoundException;
import egen.project.RestApi.entity.Alerts;

import egen.project.RestApi.entity.Readings;
import egen.project.RestApi.entity.Tires;
import egen.project.RestApi.entity.Vehicle;
import egen.project.RestApi.repository.AlertRepository;
import egen.project.RestApi.repository.ReadingRepository;
import egen.project.RestApi.repository.TireRepository;
import egen.project.RestApi.repository.VehicleRepository;

@Service
public class Vehicle_service_layer_imple implements Vehicle_Service_layer {

	
	@Autowired
	private VehicleRepository vehicleRepository;
	

	@Override
	@Transactional
	
	// For saving or updating vehicle information
	public void saveOrUpdateVehicle(List<Vehicle> vehicle) {
		
		vehicleRepository.saveAll(vehicle);
		
	}
	
	
	@Override
	public List<Vehicle> getAllVehicle() {
		// TODO Auto-generated method stub
	List<Vehicle> vehicles =(List<Vehicle>) vehicleRepository.findAll();
	
	return vehicles;
	}
	
	
    
	
	
}
