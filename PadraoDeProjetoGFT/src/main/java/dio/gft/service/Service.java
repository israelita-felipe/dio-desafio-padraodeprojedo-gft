package dio.gft.service;

import dio.gft.model.BaseEntity;
import dio.gft.model.dto.DTO;

public interface Service<T extends BaseEntity, D extends DTO<T>> extends RegistryService<T, D>, ListService<T, D> {

}
