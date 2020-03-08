package com.upm.services.service;

import com.upm.services.model.Horario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioService {

    private final HorarioRepository horarioRepository;

    public HorarioService(HorarioRepository horarioRepository) {
        this.horarioRepository = horarioRepository;
    }

    public void saveOrUpdate(Horario horario)
    {
        this.horarioRepository.save(horario);
    }

    public List<Horario> findAll()
    {
        return(List<Horario>)this.horarioRepository.findAll();
    }
}
