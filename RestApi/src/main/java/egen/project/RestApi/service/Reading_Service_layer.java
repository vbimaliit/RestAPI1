package egen.project.RestApi.service;

import java.util.List;

import egen.project.RestApi.entity.Readings;

public interface Reading_Service_layer {

	public Readings saveReadings(Readings reading);
	public List<Object[]> getGeoLoation(String vehiclenumber);
}
