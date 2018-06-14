package egen.project.RestApi.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GeoLocationNotFoundException extends RuntimeException {

	public GeoLocationNotFoundException(String message) {
	
        super(message);
    	System.out.println(" vbnm,nbvcrtvbynminubyvtcrxvgbhj");
    }
}
