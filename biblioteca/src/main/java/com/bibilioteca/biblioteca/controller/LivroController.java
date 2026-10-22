package com.bibilioteca.biblioteca.controller;

import com.bibilioteca.biblioteca.model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @GetMapping
    public String exibirLista(Model model) {
        Livro livro =  new Livro();
        livro.setLivro("Dom Casmurro");
        livro.setAutor("Machado de Assis");
        livro.setIsbn("978-85-00-00000-0");

        model.addAttribute("livro", livro);

        return "livro";
    }
}
