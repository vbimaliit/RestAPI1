package egen.project.RestApi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import egen.project.RestApi.entity.Readings;
import egen.project.RestApi.entity.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle,String>{
	
	
}
