package dio.gft.service;

import java.util.UUID;

import dio.gft.model.BaseEntity;
import dio.gft.model.dto.DTO;
import dio.gft.model.exceptions.EntityNotFoundException;
import dio.gft.model.mapper.BaseMapper;
import dio.gft.repository.CustomRepository;

public interface BaseService<T extends BaseEntity, D extends DTO<T>> {

	<R extends CustomRepository<T>> R getRepository();

	<M extends BaseMapper<T, D>> M getMapper();

	default T verifyIfExists(UUID id) throws EntityNotFoundException {
		return getRepository().findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}
}
