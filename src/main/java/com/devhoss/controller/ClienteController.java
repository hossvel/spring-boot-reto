  
package com.devhoss.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.devhoss.model.Cliente;
import com.devhoss.model.ClienteDetalle;
import com.devhoss.model.ClienteKpi;
import com.devhoss.service.IClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@RequestMapping("v1/clientes")
@Api(value="Clientes", description="Operaciones con clientes")
public class ClienteController {
	
	@Autowired
	private IClienteService iClienteService;

	@ApiOperation(value = "obtiene la lista de clientes ingresados")
	 @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "se obtuvo la lista correctamente"),
	            @ApiResponse(code = 401, message = "acceso no Autorizado"),
	            @ApiResponse(code = 404, message = "no se encontro el recurso buscado")
	    })
	@RequestMapping(value = "/findall", method = RequestMethod.GET, produces = "application/json")
   	public ResponseEntity<List<Cliente>> findall() {
		return ResponseEntity.ok(iClienteService.FindAll());
	}
	
	@ApiOperation(value = "obtiene un cliente por su id")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Cliente> getbyid(@PathVariable Long id) {
		return ResponseEntity.ok(iClienteService.FindById(id));
	}
	
	@ApiOperation(value = "Agregar un cliente")
	 @ApiResponses(value = {
	            @ApiResponse(code = 201, message = "se registro correctamente"),
	            @ApiResponse(code = 401, message = "acceso no Autorizado"),
	            @ApiResponse(code = 404, message = "no se encontro el recurso buscado"),
	            @ApiResponse(code = 400, message = "el servidor no puede procesar su request")
	 })       
    @RequestMapping(value = "/creacliente", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
		Cliente savedPersona = iClienteService.Save(cliente);
		return new ResponseEntity<>(savedPersona,HttpStatus.CREATED);
	}

	@ApiOperation(value = "Obtiene el promedio de edad y desviacion estandar de la lista de clientes")
	 @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "se obtuvo correctamente"),
	            @ApiResponse(code = 401, message = "acceso no Autorizado"),
	            @ApiResponse(code = 404, message = "no se encontro el recurso buscado")
	    })
	@RequestMapping(value = "/kpideclientes", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<ClienteKpi> kpIdeClientes() {
		return ResponseEntity.ok(iClienteService.kpIdeClientes());
	}

	@ApiOperation(value = "Obtiene la lista de personas con su fecha probable de muerte")
	 @ApiResponses(value = {
			    @ApiResponse(code = 200, message = "se obtuvo correctamente"),
			    @ApiResponse(code = 401, message = "acceso no Autorizado"),
	            @ApiResponse(code = 404, message = "no se encontro el recurso buscado")
	    })
    @RequestMapping(value = "/listclientes", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<ClienteDetalle>> listClientes() {
		return ResponseEntity.ok(iClienteService.listClientes());
	}
	
	
}
