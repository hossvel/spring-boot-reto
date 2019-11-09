package com.devhoss.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devhoss.model.Cliente;
import com.devhoss.repository.IClienteRepository;

@Service

public class ClienteServiceImpl implements IClienteService {
	
	@Autowired
	private IClienteRepository iClienteRepository;

	public List<Cliente> FindAll() {
		return iClienteRepository.findAll();
	}

	public Cliente FindById(int id) {
		return iClienteRepository.findById(id).get();
	}

	public Cliente Save(Cliente persona) {
		Cliente savedPersona = iClienteRepository.save(persona);
		return savedPersona;
	}
	
}
