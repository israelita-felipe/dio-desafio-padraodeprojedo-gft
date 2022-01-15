package dio.gft.model.dto;

import java.util.UUID;

import dio.gft.model.BaseEntity;

public interface DTO<T extends BaseEntity> {

	UUID getId();
}
