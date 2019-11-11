package com.devhoss.service;
import com.devhoss.model.Cliente;
import com.devhoss.model.ClienteDetalle;
import com.devhoss.model.ClienteKpi;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IClienteService {

	public List<Cliente> FindAll();
	
	public Cliente FindById(int id);

	public Cliente Save(Cliente persona);
	
	public ClienteKpi kpIdeClientes();
	
	public List<ClienteDetalle> listClientes();
	
}
