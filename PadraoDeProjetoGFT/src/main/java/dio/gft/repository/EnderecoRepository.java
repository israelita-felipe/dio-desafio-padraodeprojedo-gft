package dio.gft.repository;

import java.util.Optional;

import dio.gft.model.Endereco;

public interface EnderecoRepository extends CustomRepository<Endereco> {

	Optional<Endereco> findByCep(String cep);
}
