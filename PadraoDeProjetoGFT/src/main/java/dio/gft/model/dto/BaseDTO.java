package dio.gft.model.dto;

import java.util.UUID;

import dio.gft.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BaseDTO<T extends BaseEntity> implements DTO<T> {

	private UUID id;
}
