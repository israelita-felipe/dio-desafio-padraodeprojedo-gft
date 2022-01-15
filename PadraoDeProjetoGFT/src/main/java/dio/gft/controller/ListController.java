package dio.gft.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.Callable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import dio.gft.model.BaseEntity;
import dio.gft.model.dto.DTO;
import dio.gft.model.exceptions.EntityNotFoundException;

public interface ListController<T extends BaseEntity, D extends DTO<T>> extends BaseController<T, D> {

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	default Callable<D> findById(@PathVariable UUID id) throws EntityNotFoundException {
		return () -> getService().findById(id);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	default Callable<List<D>> listAll(@RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
		return () -> {
			if (page.isEmpty() || size.isEmpty()) {
				return getService().listAll();
			} else {
				return getService().list(page.get(), size.get());
			}
		};
	}

}
