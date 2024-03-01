package com.korelly.work.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.korelly.work.models.entity.Empleado;

public interface IEmpleadoService {

    public List<Empleado> findAll();
    
    public Page<Empleado> findAll(Pageable page);

    public Optional<Empleado> findById(Long id);

    public Empleado save(Empleado empleado );

    public Optional<Empleado> update(Long id,Empleado empleado);

    public Optional<Empleado> delete(Long id);

}
