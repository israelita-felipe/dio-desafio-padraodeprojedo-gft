package dio.gft.model.mapper;

import org.mapstruct.Mapper;

import dio.gft.model.Cliente;
import dio.gft.model.dto.ClienteDTO;

@Mapper(componentModel = "spring")
public interface ClienteMapper extends BaseMapper<Cliente, ClienteDTO> {

}
