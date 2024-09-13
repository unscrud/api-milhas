package dev.unscrud.api_milhas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estado")
public class EstadoController {
    @GetMapping
    public ResponseEntity<String> listarEstados(){
        return ResponseEntity.ok("Estados");
    }
}
