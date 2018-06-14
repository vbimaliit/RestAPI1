package egen.project.RestApi.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

// POJO class for Readings having one to one mapping with the tires

@Entity
@NamedQuery(name = "Readings.geoLocation" , query =" select r.latitude , r.longitude from Readings r where r.vin = :input and r.timestamp > :time")
public class Readings {
	
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE)
		private int id;
		private String vin;
		private double latitude;
		private double longitude;
		private Date timestamp;
		private double fuelVolume;
		private int speed;		
		private int engineHp;
		private boolean checkEngineLightOn;
		private boolean engineCoolantLow;
		private boolean cruiseControlOn;
		private int engineRpm;
		@OneToOne
		private Tires tires;
		
		
		public String getVin() {
			return vin;
		}
		public void setVin(String vin) {
			this.vin = vin;
		}
		public double getLatitude() {
			return latitude;
		}
		
		
		
		public Tires getTires() {
			return tires;
		}
		public void setTires(Tires tires) {
			this.tires = tires;
		}
		@Override
		public String toString() {
			return "Vehicle [vin=" + vin + ", latitude=" + latitude + ", longitude=" + longitude + ", timestamp="
					+ timestamp + ", fuelVolume=" + fuelVolume + ", speed=" + speed + ", engineHp=" + engineHp
					+ ", checkEngineLightOn=" + checkEngineLightOn + ", engineCoolantLow=" + engineCoolantLow
					+ ", cruiseControlOn=" + cruiseControlOn + ", engineRpm=" + engineRpm + ", tires=" + tires + "]";
		}
		public void setLatitude(double latitude) {
			this.latitude = latitude;
		}
		public double getLongitude() {
			return longitude;
		}
		public void setLongitude(double longitude) {
			this.longitude = longitude;
		}
		public Date getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(Date timestamp) {
			this.timestamp = timestamp;
		}
		public double getFuelVolume() {
			return fuelVolume;
		}
		public void setFuelVolume(double fuelVolume) {
			this.fuelVolume = fuelVolume;
		}
		public int getSpeed() {
			return speed;
		}
		public void setSpeed(int speed) {
			this.speed = speed;
		}
		public int getEngineHp() {
			return engineHp;
		}
		public void setEngineHp(int engineHp) {
			this.engineHp = engineHp;
		}
		public boolean isCheckEngineLightOn() {
			return checkEngineLightOn;
		}
		public void setCheckEngineLightOn(boolean checkEngineLightOn) {
			this.checkEngineLightOn = checkEngineLightOn;
		}
		public boolean isEngineCoolantLow() {
			return engineCoolantLow;
		}
		public void setEngineCoolantLow(boolean engineCoolantLow) {
			this.engineCoolantLow = engineCoolantLow;
		}
		public boolean isCruiseControlOn() {
			return cruiseControlOn;
		}
		public void setCruiseControlOn(boolean cruiseControlOn) {
			this.cruiseControlOn = cruiseControlOn;
		}
		public int getEngineRpm() {
			return engineRpm;
		}
		public void setEngineRpm(int engineRpm) {
			this.engineRpm = engineRpm;
		}
		

	
		public Readings()
		{
		}
}

