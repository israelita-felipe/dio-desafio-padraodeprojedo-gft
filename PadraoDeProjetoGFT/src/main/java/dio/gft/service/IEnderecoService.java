package dio.gft.service;

import dio.gft.model.Endereco;
import dio.gft.model.dto.EnderecoDTO;
import dio.gft.repository.EnderecoRepository;

public interface IEnderecoService extends Service<Endereco, EnderecoDTO> {

	EnderecoDTO findByCep(String cep);

	@SuppressWarnings("unchecked")
	EnderecoRepository getRepository();

}