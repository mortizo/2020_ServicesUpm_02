package com.upm.services.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {
    @RequestMapping("/")
    public String getValue()
    {
        return "Rest prueba App para UPM...";
    }
}
