package dev.unscrud.api_milhas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.unscrud.api_milhas.domain.depoimento.DepoimentoDTO;

@RestController
@RequestMapping("/depoimento")
public class DepoimentoController {

    @GetMapping
    public List<DepoimentoDTO> listarDepoimentos(){
        return null;
    }
}
