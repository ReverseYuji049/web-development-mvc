
package com.bibilioteca.biblioteca.controller;

import com.bibilioteca.biblioteca.model.Autor;
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

    private final List<Autor> autores = new ArrayList<>();

    public AutorController() {
        Autor autor = new Autor();
        autor.setNome("J.R.R. Tolkien");
        autor.setEmail("tolkienthelord@gmail.com");
        autor.setTelefone("+51 9 13791379");

        autores.add(autor);
    }

    @GetMapping
    public String inicio(Model model) {
        model.addAttribute("autores", autores);
        return "autores/inicio";
    }

    @GetMapping("/autor")
    public String exibirAutor(Model model) {
        if (autores.isEmpty()) {
            return "redirect:/autores";
        }

        model.addAttribute("autor", autores.get(0));
        return "autores/autor";
    }

    @GetMapping("/novo")
    public String novoAutor(Model model) {
        model.addAttribute("autor", new Autor());
        return "autores/form";
    }

    @PostMapping
    public String cadastraAutor(
            @ModelAttribute("autor") Autor autor,
            Model model) {

        autores.add(autor);
        model.addAttribute("autor", autor);

        return "autores/confirmacao";
    }
}
