package egen.project.RestApi.service;

import java.util.List;

import egen.project.RestApi.entity.Alerts;
import egen.project.RestApi.entity.Readings;

public interface Alert_Service_layer {
	
	public List<Alerts> getAllHighAlerts();
	
	public List<Alerts> getAllAlerts(String vehiclenumber);
	
	public void checkAlert(Readings readings);

}
