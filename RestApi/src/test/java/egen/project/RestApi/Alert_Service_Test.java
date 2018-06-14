package egen.project.RestApi;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import egen.project.RestApi.Exceptions.AlertsNotFoundException;
import egen.project.RestApi.entity.Alerts;
import egen.project.RestApi.repository.AlertRepository;
import egen.project.RestApi.service.Alert_Service_layer;
import junit.framework.Assert;

public class Alert_Service_Test {
	
	@Autowired
	private Alert_Service_layer alertservice;
	
	@MockBean
	private AlertRepository alert_repo;
	
	List<Alerts> alerts ;
	@Before
	public void setUp(){
		
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		calendar.setTime(new Date());
        calendar.add(Calendar.HOUR, -3);
        
       
		
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
		
		Alerts alert = new Alerts();
		alert.setHigh(true);
		alert.setLow(false);
		alert.setMedium(false);
		alert.setTimestamp(ds);
		
		alert.setVin("12VUVUVUVUV12");
		
		System.out.println(alert.getTimestamp());
		alerts = Collections.singletonList(alert);
		
		
		Mockito.when(alert_repo.findAll()).thenReturn(alerts);
		
		
	}

	@Test
	public void testGetAllAlerts() {
	   
	}

	@Test
	   public void testGetAllHighAlerts() {
		
		List<Alerts> alertsTest = alertservice.getAllHighAlerts();
		
		Assert.assertEquals(alerts, alertsTest);
	}

}
