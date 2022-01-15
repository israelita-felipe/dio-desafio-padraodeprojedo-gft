package dio.gft.service;

import java.util.UUID;

import dio.gft.model.BaseEntity;
import dio.gft.model.dto.DTO;
import dio.gft.model.exceptions.EntityNotFoundException;

public interface RegistryService<T extends BaseEntity, D extends DTO<T>> extends BaseService<T, D> {

	/**
	 * Create a database entity from dto entity and return its message response with
	 * id
	 * 
	 * @param <D>
	 * @param dto
	 * @return message response with the new id
	 */
	default D create(D dto) {
		// from dto to database entity
		T toSaveEntity = getMapper().toModel(dto);

		// saved database entity from repository
		T saved = getRepository().save(toSaveEntity);
		return getMapper().toDTO(saved);
	}

	default D update(UUID id, D dto) throws EntityNotFoundException {
		// verify if id is valid
		verifyIfExists(id);

		// from dto to database entity
		T toUpdateEntity = getMapper().toModel(dto);

		// saved database entity from repository
		T saved = getRepository().save(toUpdateEntity);
		return getMapper().toDTO(saved);
	}

	default void delete(UUID id) throws EntityNotFoundException {
		// verify if id is valid
		verifyIfExists(id);
		getRepository().deleteById(id);
	}

}
