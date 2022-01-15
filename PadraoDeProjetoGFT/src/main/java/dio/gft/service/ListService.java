package dio.gft.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;

import dio.gft.model.BaseEntity;
import dio.gft.model.dto.DTO;
import dio.gft.model.exceptions.EntityNotFoundException;

public interface ListService<T extends BaseEntity, D extends DTO<T>> extends BaseService<T, D> {

	/**
	 * List all entities from database
	 * 
	 * @param <D>
	 * @return List of DTO entity
	 */
	default List<D> listAll() {
		return toList(getRepository().findAll());
	}

	/**
	 * List a portion of entities using pagination
	 * 
	 * @param <D>
	 * @param page
	 * @param size
	 * @return List of DTO entity
	 */
	default List<D> list(int page, int size) {
		return toList(getRepository().findAll(PageRequest.of(page, size)).getContent());
	}

	/**
	 * convert a list of entity to list of dto entities
	 * 
	 * @param <D>
	 * @param entities
	 * @return List of DTO entity
	 */
	default List<D> toList(List<T> entities) {
		return entities.stream().map(entity -> getMapper().toDTO(entity)).toList();
	}

	/**
	 * find a dto entity from id
	 * 
	 * @param <D>
	 * @param id
	 * @return a DTO entity
	 * @throws EntityNotFoundException
	 */
	default D findById(UUID id) throws EntityNotFoundException {
		// verify if id exists on database
		T entity = verifyIfExists(id);

		// return dto from database entity
		return getMapper().toDTO(entity);
	}
}
