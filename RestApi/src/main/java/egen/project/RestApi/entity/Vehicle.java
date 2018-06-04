package egen.project.RestApi.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// POJO class for vehicles
@Entity
public class Vehicle {
	
	

	@Id
	private String vin;
	private String make;
	private String model;
	private int year;
	private int redlineRpm;
	private int maxFuelVolume;
	private Date lastServiceDate;
	
	public Vehicle(){}
	
	public Vehicle(String vin, String make, String model, int year, int readlineRpm, int maxFuelVolume,
			Date lastServiceDate) {
		super();
		this.vin = vin;
		this.make = make;
		this.model = model;
		this.year = year;
		this.redlineRpm = readlineRpm;
		this.maxFuelVolume = maxFuelVolume;
		this.lastServiceDate = lastServiceDate;
	}


	public String getVin() {
		return vin;
	}


	public void setVin(String vin) {
		this.vin = vin;
	}


	public String getMake() {
		return make;
	}


	public void setMake(String make) {
		this.make = make;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public int getRedlineRpm() {
		return redlineRpm;
	}


	public void setReadlineRpm(int readlineRpm) {
		this.redlineRpm = readlineRpm;
	}


	public int getMaxFuelVolume() {
		return maxFuelVolume;
	}


	public void setMaxFuelVolume(int maxFuelVolume) {
		this.maxFuelVolume = maxFuelVolume;
	}


	public Date getLastServiceDate() {
		return lastServiceDate;
	}


	public void setLastServiceDate(Date lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}
	
	
	
	
	
	



}
