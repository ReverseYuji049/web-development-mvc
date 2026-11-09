package com.bibilioteca.biblioteca.repository;

import com.bibilioteca.biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

// Responsável pelo acesso do banco de dados
public interface LivroRepository extends JpaRepository<Livro, Long> {
}
