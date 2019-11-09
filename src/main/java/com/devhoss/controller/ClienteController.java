  
package com.devhoss.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.devhoss.model.Cliente;
import com.devhoss.model.ClienteKpi;
import com.devhoss.service.IClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private IClienteService iClienteService;

	@GetMapping("/findall")
	public ResponseEntity<List<Cliente>> findall() {
		return ResponseEntity.ok(iClienteService.FindAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getbyid(@PathVariable int id) {
		return ResponseEntity.ok(iClienteService.FindById(id));
	}
	
	@PostMapping
	public ResponseEntity<Cliente> create(@RequestBody Cliente persona) {
		Cliente savedPersona = iClienteService.Save(persona);
		return new ResponseEntity<>(savedPersona,HttpStatus.CREATED);
	}

	@GetMapping("/kpideclientes")
	public ResponseEntity<ClienteKpi> kpIdeClientes() {
		return ResponseEntity.ok(iClienteService.kpIdeClientes());
	}

	@GetMapping("/listclientes")
	public ResponseEntity<ClienteKpi> listClientes() {
		return ResponseEntity.ok(iClienteService.kpIdeClientes());
	}
	
	
}
