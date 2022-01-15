package dio.gft.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import dio.gft.model.dto.ClienteDTO;
import dio.gft.model.dto.EnderecoDTO;
import dio.gft.model.exceptions.EntityNotFoundException;
import dio.gft.model.mapper.ClienteMapper;
import dio.gft.repository.ClienteRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Service
@Getter
@RequiredArgsConstructor
class ClienteService implements IClienteService {

	private final IEnderecoService enderecoService;
	private final ClienteMapper mapper;
	private final ClienteRepository repository;

	@Override
	public ClienteDTO create(ClienteDTO dto) {
		return IClienteService.super.create(atualizaEnderecoCliente(dto));
	}

	@Override
	public ClienteDTO update(UUID id, ClienteDTO dto) throws EntityNotFoundException {
		return IClienteService.super.update(id, atualizaEnderecoCliente(dto));
	}

	private ClienteDTO atualizaEnderecoCliente(ClienteDTO cliente) {
		String cep = cliente.getEndereco().getCep();
		// busca o cep na camada de serviço
		EnderecoDTO endereco = enderecoService.findByCep(cep);
		// atualiza o endereço do dto
		cliente.setEndereco(endereco);
		return cliente;
	}

}
