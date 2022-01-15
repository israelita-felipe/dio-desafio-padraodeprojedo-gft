package dio.gft.service;

import org.springframework.stereotype.Service;

import dio.gft.model.dto.EnderecoDTO;
import dio.gft.model.mapper.EnderecoMapper;
import dio.gft.repository.EnderecoRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Service
@Getter
@RequiredArgsConstructor
class EnderecoService implements IEnderecoService {

	private final ViaCepService viaCepService;
	private final EnderecoMapper mapper;
	private final EnderecoRepository repository;

	@Override
	public EnderecoDTO findByCep(String cep) {
		EnderecoDTO endereco = getRepository().findByCep(cep)
				// mapeando para dto
				.map(getMapper()::toDTO).orElseGet(() -> {
					// Caso não exista, integrar com o ViaCEP e persistir o retorno.
					EnderecoDTO novoEndereco = viaCepService.consultarCep(cep);
					novoEndereco = create(novoEndereco);
					return novoEndereco;
				});
		return endereco;
	}

}
