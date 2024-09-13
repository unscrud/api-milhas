package dev.unscrud.api_milhas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.unscrud.api_milhas.domain.estado.EstadoRepository;
import dev.unscrud.api_milhas.domain.estado.EstadoResponseDTO;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @GetMapping
    public ResponseEntity<List<EstadoResponseDTO>> listarEstados(){
        List<EstadoResponseDTO> estados = estadoRepository
                .findAll().stream()
                .map(EstadoResponseDTO::new).toList();

        return ResponseEntity.ok(estados);
    } 
}
