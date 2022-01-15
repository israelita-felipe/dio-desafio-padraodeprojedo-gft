package dio.gft.model.mapper;

import org.mapstruct.Mapper;

import dio.gft.model.Endereco;
import dio.gft.model.dto.EnderecoDTO;

@Mapper(componentModel = "spring")
public interface EnderecoMapper extends BaseMapper<Endereco, EnderecoDTO> {

}
