package dio.gft.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dio.gft.model.Cliente;
import dio.gft.model.dto.ClienteDTO;
import dio.gft.service.IClienteService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteRestController extends AbstractController<Cliente, ClienteDTO> {

	@Getter
	private final IClienteService service;

}
