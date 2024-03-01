package com.korelly.work.models.service;

import java.util.List;
import java.util.Optional;

import com.korelly.work.models.entity.Cliente;

public interface IClienteService {

    public List<Cliente> findAll();

    public Optional<Cliente> findById(Long id);

    public void save(Cliente cliente );

    public void update(Long id,Cliente cliente);

    public void delete(Long id);
}
