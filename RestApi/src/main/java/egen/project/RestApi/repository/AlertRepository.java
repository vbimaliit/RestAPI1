package egen.project.RestApi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import egen.project.RestApi.entity.Alerts;

public interface AlertRepository  extends CrudRepository<Alerts,Integer>{

	public List<Alerts> findHighAlert(@Param("time") Date time);
	public List<Alerts> findAllAlerts(@Param("vehiclenumber") String vehiclenumber);

	
}
