package com.bibilioteca.biblioteca.controller;

import com.bibilioteca.biblioteca.model.Autor;
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

@RequestMapping("/autores")
public class AutorController {

    private List<Autor> autores = new ArrayList<>();

    @GetMapping
    public String inicio() {
        return "autores/inicio";
    }

    @GetMapping("/autor")
    public String exibirLista(Model model) {
        Autor autor = new Autor();
        autor.setNome("J.R.R Tolkien");
        autor.setEmail("tolkienthelord@gmail.com");
        autor.setTelefone("+51 9 13791379");

        model.addAttribute("autor", autor);

        return "autor";
    }

    @GetMapping("/autores/novo")
    public String novoAutor() {
        return "autores/novo";
    }

    @PostMapping("/autores")
    public String cadastraAutor(@ModelAttribute Autor autor){
        return "autores/confirmacao";
    }
}
