package com.upm.services.controller;

import com.upm.services.model.Horario;
import com.upm.services.service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HorarioController {

    @Autowired
    HorarioService horarioService;

    @PostMapping(value="/horario")
    public void setHorario(@RequestBody Horario horario){

        this.horarioService.saveOrUpdate(horario);
    }

    @GetMapping(value="/horario")
    public List<Horario> getHorarioList(){
        return this.horarioService.findAll();
    }

    @GetMapping(value="/horario1")
    public String getSaludo(){
        return "Devolviendo un afectuoso saludo";
    }
}
