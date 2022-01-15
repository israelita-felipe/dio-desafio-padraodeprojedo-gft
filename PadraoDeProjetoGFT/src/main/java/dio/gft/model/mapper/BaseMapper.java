package dio.gft.model.mapper;

import dio.gft.model.BaseEntity;
import dio.gft.model.dto.DTO;

public interface BaseMapper<T extends BaseEntity, D extends DTO<T>> {

	T toModel(D dto);

	D toDTO(T dto);
}
