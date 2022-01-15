package dio.gft.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
public class Cliente extends BaseEntity {

	private String nome;
	@ManyToOne
	private Endereco endereco;
}
