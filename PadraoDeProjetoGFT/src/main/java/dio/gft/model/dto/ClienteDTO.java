package dio.gft.model.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import dio.gft.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ClienteDTO extends BaseDTO<Cliente> {

	@NotNull
	@NotEmpty
	private String nome;

	@Valid
	@NotNull
	private EnderecoDTO endereco;
}
