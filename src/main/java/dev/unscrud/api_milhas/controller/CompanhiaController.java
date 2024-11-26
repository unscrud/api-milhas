package dev.unscrud.api_milhas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.unscrud.api_milhas.domain.companhia.CompanhiaRepository;
import dev.unscrud.api_milhas.domain.companhia.CompanhiaResponseDTO;

@RestController
@RequestMapping("/companhia")
public class CompanhiaController {

    @Autowired
    private CompanhiaRepository companhiaRepository;

    @GetMapping
    public ResponseEntity<List<CompanhiaResponseDTO>> getCompanhias() {
        List<CompanhiaResponseDTO> companhias = companhiaRepository
                .findAll().stream()
                .map(CompanhiaResponseDTO::new).toList();

        return ResponseEntity.ok(companhias);
    }

}
