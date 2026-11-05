package com.bibilioteca.biblioteca.controller;

import com.bibilioteca.biblioteca.model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
// Endereço que responde na solicitação/chamada de /livros
@RequestMapping("/livros")
public class LivroController {

    private List<Livro> livros = new ArrayList<>();

    public LivroController() {
        Livro livro = new Livro();
        livro.setTitulo("Dom Casmurro");
        livro.setAutor("Machado de Assis");
        livro.setIsbn("978-85-00-00000-0");

        livros.add(livro);
    }

    // Ativado com o método GET
    @GetMapping
    public String inicio(Model model) {
        model.addAttribute("livros", livros);
        return "livros/inicio";
    }

    @GetMapping("/novo")
    public String novoLivro(Model model) {
        model.addAttribute("livro", new Livro());
        return "livros/form";
    }

    @PostMapping
    public String cadastrar(@ModelAttribute Livro livro) {
        livros.add(livro);
        // Redireciona para uma página específica
        return "redirect:/livros";
    }

    @GetMapping("/livros")
    public String listar(Model model) {
        model.addAttribute("livros", livros);
        return "livros/lista";
    }

    // Remoção de Livro
    @GetMapping("/excluir/{idx}")
    public String excluir(@PathVariable int idx) {
        livros.remove(idx);
        return "redirect:/livros";
    }
}
