package egen.project.RestApi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import egen.project.RestApi.entity.Readings;

public interface ReadingRepository extends CrudRepository<Readings,String> {
	public List<Object[]> geoLocation(@Param ("input") String input,@Param("time") Date time);

}