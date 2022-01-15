package dio.gft.controller;

import java.util.UUID;
import java.util.concurrent.Callable;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import dio.gft.model.BaseEntity;
import dio.gft.model.dto.DTO;
import dio.gft.model.exceptions.EntityNotFoundException;

public interface RegisterController<T extends BaseEntity, D extends DTO<T>> extends BaseController<T, D> {

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	default Callable<D> create(@RequestBody @Valid D dto) {
		return () -> getService().create(dto);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	default Callable<D> update(@PathVariable UUID id, @RequestBody @Valid D dto) throws EntityNotFoundException {
		return () -> getService().update(id, dto);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	default Callable<Void> delete(@PathVariable UUID id) throws EntityNotFoundException {
		return () -> {
			getService().delete(id);
			return (Void) null;
		};
	}
}
