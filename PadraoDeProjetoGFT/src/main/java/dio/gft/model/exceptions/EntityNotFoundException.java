package dio.gft.model.exceptions;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends Exception {

	private UUID id;

	public EntityNotFoundException(String entityName, UUID id) {
		super(String.format("Not found %s with id %s", id.toString()));
	}

	public EntityNotFoundException(UUID id) {
		super(String.format("Not found with id %s", id.toString()));
	}

}
