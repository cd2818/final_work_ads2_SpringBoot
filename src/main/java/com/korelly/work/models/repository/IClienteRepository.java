package com.korelly.work.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.korelly.work.models.entity.Cliente;

public interface IClienteRepository extends CrudRepository<Cliente,Long>{

}
