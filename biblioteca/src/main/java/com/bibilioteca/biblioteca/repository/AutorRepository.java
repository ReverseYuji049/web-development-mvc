package com.bibilioteca.biblioteca.repository;

import com.bibilioteca.biblioteca.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
