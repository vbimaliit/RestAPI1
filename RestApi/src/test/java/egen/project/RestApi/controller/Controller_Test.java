package egen.project.RestApi.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import egen.project.RestApi.entity.Vehicle;
import egen.project.RestApi.repository.VehicleRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(
	webEnvironment = SpringBootTest.WebEnvironment.MOCK
)
@AutoConfigureMockMvc
@ActiveProfiles("integration")
public class Controller_Test {
	
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private VehicleRepository vehiclerepo;
	
	@Autowired
	ObjectMapper objectmapper;
	
	List<Vehicle> vehicles= new ArrayList<Vehicle>();

	@Before
	public void setUp(){
		
		Vehicle vehicle = new Vehicle("12CWNCNWOVNWOV","PORSCHE", "CAYENNE",2015,8000,18,new Date());
		
		vehicles.add(vehicle);
		
		Vehicle vehicle1 = new Vehicle("12CWNCNWOVNWOV","POR", "CAY",2015,8000,18,new Date());
		
		vehicles.add(vehicle1);
		
		vehiclerepo.saveAll(vehicles);
	}
	
	@After
	public void CleanUp(){
		vehiclerepo.deleteAll();
	}
	
	@Test
	public void testSaveVehicle() throws Exception {
		
		ObjectMapper obm = new ObjectMapper();
		Vehicle vehicle = new Vehicle("12CWNCNWOVNWOV","PORSCHE", "CAYENNE",2015,8000,18,new Date());
		
		mvc.perform(MockMvcRequestBuilders.put("/vehicles").content(obm.writeValueAsBytes(vehicle)))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.vin",Matchers.notNullValue()));
		
				
		
	}

	@Test
	public void testGetAllVehicles() throws Exception {
		
		mvc.perform(MockMvcRequestBuilders.get("/vehicles")).andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)));
	
	}

}
