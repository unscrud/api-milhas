package dev.unscrud.api_milhas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
    @GetMapping("/login")
    public void efetuarLogin(){
        System.out.println("vai fazer login");
    }
}
