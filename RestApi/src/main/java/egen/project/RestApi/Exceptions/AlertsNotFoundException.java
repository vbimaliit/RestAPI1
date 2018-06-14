package egen.project.RestApi.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AlertsNotFoundException extends Exception {

	public AlertsNotFoundException(String message){
		super(message);
	}
}
