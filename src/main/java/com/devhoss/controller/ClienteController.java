  
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
import com.devhoss.service.IClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private IClienteService iClienteService;

	@GetMapping("/findall")
	public List<Cliente> findall() {
		return iClienteService.FindAll();
	}
	@GetMapping("/{id}")
	public Cliente getbyid(@PathVariable int id) {
		return iClienteService.FindById(id);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> create(@RequestBody Cliente persona) {
		Cliente savedPersona = iClienteService.Save(persona);
		return new ResponseEntity<>(savedPersona,HttpStatus.CREATED);
	}

	
}
