package com.Equalizer.servicesImpl;

import com.Equalizer.model.Cliente;
import com.Equalizer.repositories.ClienteRepository;
import com.Equalizer.services.ClienteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

	private final ClienteRepository clienteRepository;

	@Autowired
	public ClienteServiceImpl(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Override
	public List<Cliente> getAllClientes() {
		return clienteRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente getClienteById(Long id) {
		return clienteRepository.findById(id).orElseThrow(() ->
				new EntityNotFoundException("Cliente com ID " + id + " não encontrado."));
	}

	@Override
	@Transactional
	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	@Transactional
	public Cliente updateCliente(Long id, Cliente clienteAtualizado) {
		Cliente clienteExistente = clienteRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Cliente com ID " + id + " não encontrado."));

		clienteExistente.setNome(clienteAtualizado.getNome());
		clienteExistente.setDescricao(clienteAtualizado.getDescricao());

		return clienteRepository.save(clienteExistente);
	}

	@Override
	@Transactional
	public void deleteCliente(Long id) {
		clienteRepository.deleteById(id);
	}
}