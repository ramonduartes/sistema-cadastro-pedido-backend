package br.com.wmw.wmw.comprasappbe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.wmw.wmw.comprasappbe.dto.ClienteDTO;
import br.com.wmw.wmw.comprasappbe.models.Cliente;
import br.com.wmw.wmw.comprasappbe.repo.ClienteRepository;
@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<ClienteDTO> lista() {
		List<Cliente> clientes = clienteRepository.findAll();
		return ClienteDTO.converter(clientes);
	}

	public ClienteDTO detalhar(@PathVariable Long id) throws Exception {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) {
			return new ClienteDTO(cliente.get());
		} else {
			throw new Exception();
		}
	}
}
