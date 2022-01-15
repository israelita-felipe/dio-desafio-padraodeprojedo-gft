package dio.gft.controller;

import dio.gft.model.BaseEntity;
import dio.gft.model.dto.DTO;

public interface Controller<T extends BaseEntity, D extends DTO<T>> extends ListController<T,D>, RegisterController<T,D> {

}
