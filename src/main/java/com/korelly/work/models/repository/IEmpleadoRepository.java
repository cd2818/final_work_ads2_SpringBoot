package com.korelly.work.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.korelly.work.models.entity.Empleado;

public interface IEmpleadoRepository extends JpaRepository<Empleado, Long>{

}
