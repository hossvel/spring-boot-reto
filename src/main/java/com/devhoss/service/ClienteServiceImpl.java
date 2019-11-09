package com.devhoss.service;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devhoss.model.Cliente;
import com.devhoss.model.ClienteKpi;
import com.devhoss.repository.IClienteRepository;
import com.devhoss.utils.Utils;

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

	public ClienteKpi kpIdeClientes() {
		Collection<Cliente> clientes = iClienteRepository.findAll();
		List<Integer> edades = clientes.stream()
				.map(Cliente::getEdad).collect(Collectors.toList());

		double promedio = Utils.promedioEdades(edades.stream().mapToInt(x -> x).toArray());
		double desviacion = Utils.desviacionEstandar(edades.stream().mapToInt(x -> x).toArray());
		ClienteKpi respuesta = new ClienteKpi() {
			{
				setPromedioEdades(promedio);
				setDesviacionEstandarEdades(desviacion);
			}
		};
		return respuesta;
	}



}
