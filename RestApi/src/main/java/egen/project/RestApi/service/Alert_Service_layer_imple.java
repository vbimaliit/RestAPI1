package egen.project.RestApi.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import egen.project.RestApi.Exceptions.AlertsNotFoundException;
import egen.project.RestApi.entity.Alerts;
import egen.project.RestApi.entity.Readings;
import egen.project.RestApi.entity.Tires;
import egen.project.RestApi.entity.Vehicle;
import egen.project.RestApi.repository.AlertRepository;
import egen.project.RestApi.repository.VehicleRepository;
@Service
public class Alert_Service_layer_imple implements Alert_Service_layer {
	

	@Autowired
	private AlertRepository alertRepository;
	

	@Autowired
	private VehicleRepository vehicleRepository;

	@Override
	public List<Alerts> getAllAlerts(String vehiclenumber) {
		// TODO Auto-generated method stub
		List<Alerts> alerts = alertRepository.findAllAlerts(vehiclenumber);
		if(alerts.size() ==0)
		
		{
			 try {
				throw new AlertsNotFoundException("No alerts found for vehicle number" + vehiclenumber) ;
			} catch (AlertsNotFoundException e) {}
		}
		return alerts;
	}
	
	@Override
	public List<Alerts> getAllHighAlerts() {

		Date date1 = calculateDateTime("hour" , 2);
	
		
		List<Alerts> alerts = (List<Alerts>) alertRepository.findHighAlert(date1);
		if(alerts.size() == 0)
		{
			 try {
				throw new AlertsNotFoundException("No high alerts found in last 2 hours") ;
			} catch (AlertsNotFoundException e) {}
		}
		
		
		return alerts;
		
	}
	
	@Async
	public void checkAlert(Readings reading)
	{
	
		boolean check = false;
		boolean low = false;
		boolean high = false;
		boolean medium = false;
		Tires tire = reading.getTires();
		if (tire.getFrontLeft() < 32  || tire.getFrontLeft() > 36 || 
				tire.getFrontRight() < 32 || tire.getFrontRight() > 36 ||
				tire.getRearLeft() < 32 || tire.getRearLeft() > 36 ||
				tire.getRearRight() < 32 || tire.getRearRight() > 36
				||reading.isCheckEngineLightOn() || reading.isEngineCoolantLow())
		{
			
			check = true;
			low = true;
			
		}
		
		
		
		Optional<Vehicle> vehicle = vehicleRepository.findById(reading.getVin());
		if(vehicle.isPresent())
		{
			if(reading.getEngineRpm() > vehicle.get().getRedlineRpm()){
				check = true;
				high = true;
			}
			
			if (reading.getFuelVolume() < (.1 * vehicle.get().getMaxFuelVolume())){
				check = true;
				medium = true;
				
			}
		}
		
		if(check){
			Alerts alert = new Alerts();
			alert.setVin(reading.getVin());
			alert.setHigh(high);
			alert.setLow(low);
			alert.setMedium(medium);
			alert.setTimestamp(reading.getTimestamp());
			alertRepository.save(alert);
			
		}
	}	

		public Date calculateDateTime(String timeType, int time)
	    {
	    	
	    	
	    	Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
			calendar.setTime(new Date());
	        switch (timeType){
	        case "minute" : 
	        	calendar.add(Calendar.MINUTE, -time);
	        	break;
	        case "hour" :
	        	calendar.add(Calendar.HOUR, -time);
	        	break;
	        }
			
			Date dateToLookBackAfter = (Date) calendar.getTime();
			
			SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String newTime = sm.format(dateToLookBackAfter);
			Date ds = null;
			try {
			ds = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(newTime);
			} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	    	
			return ds;
	    }

}
