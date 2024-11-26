package dev.unscrud.api_milhas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companhia")
public class CompanhiaController {

    @GetMapping
    public String getCompanhias() {
        String  teste = "teste";
        return teste;
    }

}
