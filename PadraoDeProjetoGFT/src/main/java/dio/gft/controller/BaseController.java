package dio.gft.controller;

import dio.gft.model.BaseEntity;
import dio.gft.model.dto.DTO;
import dio.gft.service.Service;

public interface BaseController<T extends BaseEntity, D extends DTO<T>> {

	Service<T, D> getService();
}
