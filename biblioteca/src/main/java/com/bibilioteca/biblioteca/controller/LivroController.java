package com.bibilioteca.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// Endereço que responde na solicitação/chamada de /livros
@RequestMapping("/livros")
public class LivroController {
    // Ativado com o método GET
    @GetMapping
    public String inicio() {
        return "livros/inicio";
    }
}
