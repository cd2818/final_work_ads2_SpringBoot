package com.korelly.work.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.korelly.work.models.entity.Empleado;
import com.korelly.work.models.service.IEmpleadoService;
import com.korelly.work.paginator.PageRender;

@Controller
public class EmpleadosController {

    @Autowired
    private IEmpleadoService empleadoService;

    @GetMapping("/listar")
    public String listar(@RequestParam(name = "page",defaultValue = "0") int page, Model model){
        Pageable pageRequest = PageRequest.of(page,5);
        Page<Empleado> empleados = empleadoService.findAll(pageRequest);
        PageRender<Empleado> pageRender = new PageRender<Empleado>("/listar-empleados",empleados);

        model.addAttribute("titulo", "Listado de clientes");
        model.addAttribute("empleados", empleados);
        model.addAttribute("page", pageRender);

        return "listar-empleados";
    }

}
