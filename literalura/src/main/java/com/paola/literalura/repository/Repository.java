package com.paola.literalura.repository;

import com.paola.literalura.model.Autor;
import com.paola.literalura.model.Idioma;
import com.paola.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface Repository extends JpaRepository<Autor, Long> {
    @Query("SELECT a FROM Libro l JOIN l.autor a WHERE a.nombre LIKE %:nombre%")
    Optional<Autor> buscarAutorPorNombre(String nombre);

    @Query("SELECT l FROM Libro l JOIN l.autor a WHERE l.titulo LIKE %:nombre%")
    Optional<Libro> buscarLibroPorNombre(String nombre);

    @Query("SELECT l FROM Autor a JOIN a.libros l")
    List<Libro> buscarTodosLosLibros();

    @Query("SELECT a FROM Autor a WHERE a.fallecimiento > :fecha")
    List<Autor> buscarAutoresVivos(Integer fecha);

    @Query("SELECT l FROM Autor a JOIN a.libros l WHERE l.lenguaje = :idioma ")
    List<Libro> buscarLibrosPorIdioma(Idioma idioma);
}
