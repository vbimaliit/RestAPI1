package egen.project.RestApi;



import static org.junit.Assert.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import egen.project.RestApi.entity.Vehicle;
import egen.project.RestApi.repository.VehicleRepository;
import egen.project.RestApi.service.Vehicle_Service_layer;
import egen.project.RestApi.service.Vehicle_service_layer_imple;
import junit.framework.Assert;

@RunWith(SpringRunner.class)
public class Vehicle_Service_layer_test {

	List<Vehicle> vehicles;
	
	@TestConfiguration
	static class VehicleServiceTestConfig{
		@Bean
		public Vehicle_Service_layer getVehicleService(){
			return new Vehicle_service_layer_imple();
		}
	}
	
	@MockBean
	private VehicleRepository vehicle_repo;
	
	
	@Before
	public void setUp(){
		Vehicle vehicle = new Vehicle("12CWNCNWOVNWOV","PORSCHE", "CAYENNE",2015,8000,18,new Date());
		
		 vehicles = Collections.singletonList(vehicle);
		Mockito.when(vehicle_repo.findAll()).thenReturn(vehicles);
	
	}
	
	@Autowired
	private Vehicle_Service_layer vehicle_service;
	
	
	
	@Test
	public void testSaveOrUpdateVehicle() {
		
		
		
	}

	@Test
	public void testGetAllVehicle() {
	
		List<Vehicle> vehiclesTest = vehicle_service.getAllVehicle();
		Assert.assertEquals(vehicles, vehiclesTest);
	}

}
