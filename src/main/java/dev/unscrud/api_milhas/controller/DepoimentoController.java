package dev.unscrud.api_milhas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.unscrud.api_milhas.domain.depoimento.DepoimentoRepository;
import dev.unscrud.api_milhas.domain.depoimento.DepoimentoResponseDTO;

@RestController
@RequestMapping("/depoimento")
public class DepoimentoController {

    @Autowired
    private DepoimentoRepository depoimentoRepository;

    @GetMapping
    public ResponseEntity<List<DepoimentoResponseDTO>> listarDepoimentos(){
        List<DepoimentoResponseDTO> depoimentos = depoimentoRepository
                .findAll().stream()
                .map(DepoimentoResponseDTO::new).toList();

        return ResponseEntity.ok(depoimentos);
    }
}
