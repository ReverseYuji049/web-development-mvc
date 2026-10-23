package com.bibilioteca.biblioteca.controller;

import com.bibilioteca.biblioteca.model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
// Endereço que responde na solicitação/chamada de /livros
@RequestMapping("/livros")
public class LivroController {

    private List<Livro> livros = new ArrayList<>();

    // Ativado com o método GET
    @GetMapping
    public String inicio() {
        return "livros/inicio";
    }
    @GetMapping("/livro")
    public String exibirLista(Model model) {
        Livro livro =  new Livro();
        livro.setLivro("Dom Casmurro");
        livro.setAutor("Machado de Assis");
        livro.setIsbn("978-85-00-00000-0");

        // Passa um atributo "livro" para o modelo
        model.addAttribute("livro", livro);

        return "livro";
    }

    @GetMapping("/livros/novo")
    public String novoLivro() {
        return "livros/novo";
    }

    @PostMapping("/livros")
    public String cadastraLivro(@ModelAttribute Livro livro){
        return "livros/confirmacao";
    }
}
