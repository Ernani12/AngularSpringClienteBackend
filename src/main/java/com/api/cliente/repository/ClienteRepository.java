package com.api.cliente.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.cliente.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente,Long> {

}
