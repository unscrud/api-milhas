package dev.unscrud.api_milhas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.unscrud.api_milhas.domain.promocao.Promocao;
import dev.unscrud.api_milhas.domain.promocao.PromocaoRepository;

@RestController
@RequestMapping("/promocao")
public class PromocaoController {

    @Autowired
    private PromocaoRepository promocaoRepository;

    @GetMapping
    public ResponseEntity<List<Promocao>> listarPromocoes(){
        return ResponseEntity.ok(promocaoRepository.findAll());
    }
}
