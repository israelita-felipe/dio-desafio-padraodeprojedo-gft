package dio.gft.controller;

import dio.gft.model.BaseEntity;
import dio.gft.model.dto.DTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class AbstractController<T extends BaseEntity, D extends DTO<T>> implements Controller<T, D> {

}
