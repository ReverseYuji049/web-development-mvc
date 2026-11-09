package com.bibilioteca.biblioteca.controller;

import com.bibilioteca.biblioteca.model.Livro;
import com.bibilioteca.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
// Endereço que responde na solicitação/chamada de /livros
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("livros", livroRepository.findAll());
        return "livros/lista";
    }

    @GetMapping("/novo")
    public String novoLivro(Model model) {
        model.addAttribute("livro", new Livro());
        return "livros/form";
    }

    @PostMapping
    public String cadastrar(@ModelAttribute Livro livro) {
        livroRepository.save(livro);
        // Redireciona para uma página específica
        return "redirect:/livros";
    }


    // Remoção de Livro
    @GetMapping("/excluir/{id}") // Define a rota a ser acionada
    public String excluir(@PathVariable Long id) {
        livroRepository.deleteById(id);
        return "redirect:/livros";
    }
}
