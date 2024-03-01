package com.korelly.work.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.korelly.work.models.entity.Empleado;
import com.korelly.work.models.repository.IEmpleadoRepository;

@Service
public class EmpleadoServiceImp implements IEmpleadoService {

    @Autowired
    private IEmpleadoRepository empleadoRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Empleado> findAll() {
        return (List<Empleado>) empleadoRepository.findAll();
    }

    @SuppressWarnings("null")
    @Override
	@Transactional(readOnly = true)
	public Page<Empleado> findAll(Pageable page) {

		return empleadoRepository.findAll(page);
	}


    @SuppressWarnings("null")
    @Transactional(readOnly = true)
    @Override
    public Optional<Empleado> findById(Long id) {

        return empleadoRepository.findById(id);
    }

    @SuppressWarnings("null")
    @Transactional(readOnly = false)
    @Override
    public Empleado save(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @SuppressWarnings("null")
    @Transactional(readOnly = false)
    @Override
    public Optional<Empleado> delete(Long id) {
        Optional<Empleado> empleadoDB = empleadoRepository.findById(id);

        empleadoDB.ifPresent(p -> {
            empleadoRepository.delete(p);
        });

        return empleadoDB;
    }

    @SuppressWarnings("null")
    @Transactional(readOnly = false)
    @Override
    public Optional<Empleado> update(Long id, Empleado empleado) {
        Optional<Empleado> empleadoOptional = empleadoRepository.findById(id);

        if(empleadoOptional.isPresent()){
            Empleado empleadoDB = empleadoOptional.orElseThrow();

            empleadoDB.setAp_materno(empleado.getAp_materno());
            empleadoDB.setAp_paterno(empleado.getAp_paterno());
            empleadoDB.setDireccion(empleado.getDireccion());
            empleadoDB.setEmail(empleado.getEmail());
            empleadoDB.setEstado(empleado.getEstado());
            empleadoDB.setSueldo(empleado.getSueldo());
            empleadoDB.setHora_entrada(empleado.getHora_entrada());
            empleadoDB.setHora_salida(empleado.getHora_salida());
            empleadoDB.setNombre(empleado.getNombre());
            empleadoDB.setNro_dni(empleado.getNro_dni());
            empleadoDB.setNro_telefono(empleado.getNro_telefono());
        }
        

        return empleadoOptional;
    }

}
