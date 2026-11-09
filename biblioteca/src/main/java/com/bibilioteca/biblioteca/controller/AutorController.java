
package com.bibilioteca.biblioteca.controller;

import com.bibilioteca.biblioteca.model.Autor;
import com.bibilioteca.biblioteca.repository.AutorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/autores")
public class AutorController {

    private final AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("autores", autorRepository.findAll());
        return "autores/lista";
    }

    @GetMapping("/novo")
    public String novoAutor(Model model) {
        model.addAttribute("autor", new Autor());
        return "autores/form";
    }

    @PostMapping
    public String cadastrar(@ModelAttribute("autor") Autor autor) {
        autorRepository.save(autor);
        return "redirect:/autores";
    }
    // Remoção de autor
    @GetMapping("/excluir/{id}") // Define a rota a ser acionada
    public String excluir(@PathVariable Long id) {
        autorRepository.deleteById(id);
        return "redirect:/autores";
    }
}
