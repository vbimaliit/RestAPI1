package egen.project.RestApi.service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import egen.project.RestApi.Exceptions.GeoLocationNotFoundException;
import egen.project.RestApi.entity.Alerts;
import egen.project.RestApi.entity.Readings;
import egen.project.RestApi.entity.Tires;
import egen.project.RestApi.entity.Vehicle;
import egen.project.RestApi.repository.ReadingRepository;
import egen.project.RestApi.repository.TireRepository;

@Service

public class Reading_Service_Layer_imple implements Reading_Service_layer {
	
	@Autowired
	private ReadingRepository readingRepository;
	
	@Autowired
	private TireRepository tireRepository;
	
	@Autowired
	private Alert_Service_layer alert_service;
	


	@Override
	@Transactional
	// For saving readings
	public Readings saveReadings(Readings reading) {
	
		
		tireRepository.save(reading.getTires());
		readingRepository.save(reading);
		alert_service.checkAlert(reading);
		return reading;
	}

	@Override
	public List<Object[]> getGeoLoation(String vehiclenumber) {
		// TODO Auto-generated method stub
		
		Date ds = calculateDateTime("minute" , 30);
		List<Object[]> geolocations = readingRepository.geoLocation(vehiclenumber, ds);
		if(geolocations.size() == 0)
		{
			System.out.println("erroor");
			 try {
				throw new GeoLocationNotFoundException( "No Geolocation found in last 30 minutes for vehilce number" + vehiclenumber) ;
		
			} catch (GeoLocationNotFoundException e) {}
		}
		return geolocations;	
	
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
