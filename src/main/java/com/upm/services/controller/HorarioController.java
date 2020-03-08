package com.upm.services.controller;

import com.upm.services.model.Horario;
import com.upm.services.service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @GetMapping(value="/method1")
    @ResponseBody
    public String getMethod1(@RequestParam String id){
        return "Devolviendo un afectuoso saludo para "+id;
    }
    //http://localhost:8080/method1?id=Mauricio%20Ortiz

    @GetMapping(value="/method2")
    @ResponseBody
    public String getMethod2(@RequestParam(name = "id") String paramID, @RequestParam String paramName) {
        return "Devolviendo un afectuoso saludo para el código "+paramID+" de "+paramName;
    }
    //http://localhost:8080/method2?id=20163&paramName=Mauricio%20Ortiz%20Ochoa

    @GetMapping(value="/method3")
    @ResponseBody
    public String getMethod3(@RequestParam String paramID, @RequestParam String paramName,
                             @RequestParam (required = false) Optional<String> paramOptional) {
        return "Devolviendo un afectuoso saludo para el código "+paramID+" de "+paramName+
                "Parametro opcional ="+paramOptional.orElseGet(()->"No registrado");
    }
    //http://localhost:8080/method3?paramID=20163&paramName=Mauricio%20Ortiz%20Ochoa&paramOptional=%22HOLA%22
    //http://localhost:8080/method3?paramID=20163&paramName=Mauricio%20Ortiz%20Ochoa

    @GetMapping(value="/method4")
    @ResponseBody
    public String getMethod4(@RequestParam(defaultValue = "todos") String id){
        return "Devolviendo un afectuoso saludo para "+id;
    }
    //http://localhost:8080/method4?id=Mauricio%20Ortiz
    //http://localhost:8080/method4

    @GetMapping(value="/method5")
    @ResponseBody
    public String getMethod5(@RequestParam Map<String,String> paramAll){
        return "Devolviendo un afectuoso saludo para "+paramAll.entrySet();
    }
    //http://localhost:8080/method5?1=mauricio ortiz&2=Cuenca&3=0984357604

    @GetMapping(value="/method6")
    @ResponseBody
    public String getMethod6(@RequestParam List<String> paramList){
        return "Devolviendo un afectuoso saludo para "+paramList.toString();
    }
    //http://localhost:8080/method6?paramList=mauricio, juana, maria esperanza, ana maria, maria victoria

    @GetMapping(value="/method7/{paramId}")
    @ResponseBody
    public String getMethod7(@PathVariable String paramId){
        return "Devolviendo un afectuoso saludo para "+paramId;
    }
    //http://localhost:8080/method7/Mauricio Ortiz



}
