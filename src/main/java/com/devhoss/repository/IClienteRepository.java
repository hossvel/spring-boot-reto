package com.devhoss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devhoss.model.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer>{

}
