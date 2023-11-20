package com.Equalizer.services;

import com.Equalizer.model.Cliente;

import java.util.List;

public interface ClienteService {

	List<Cliente> getAllClientes();


	Cliente getClienteById(Long id);


	Cliente saveCliente(Cliente cliente);


	Cliente updateCliente(Long id, Cliente clienteAtualizado);


	void deleteCliente(Long id);
}

