package com.example.buscarlibro.repository;

import com.example.buscarlibro.R;
import com.example.buscarlibro.model.Libro;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private static BookRepository instance;
    private List<Libro> libros;

    private BookRepository() {
        initializeBooks();
    }

    public static BookRepository getInstance() {
        if (instance == null) {
            instance = new BookRepository();
        }
        return instance;
    }

    private void initializeBooks() {
        libros = new ArrayList<>();
        
        libros.add(new Libro(
            "Cien años de soledad",
            "Gabriel García Márquez",
            1967,
            "Una obra maestra del realismo mágico que narra la historia de la familia Buendía a lo largo de siete generaciones en el pueblo ficticio de Macondo.",
            R.drawable.cien_anos_soledad
        ));

        libros.add(new Libro(
            "Don Quijote de la Mancha",
            "Miguel de Cervantes",
            1605,
            "La historia del ingenioso hidalgo Don Quijote y su fiel escudero Sancho Panza en sus aventuras por los campos de La Mancha.",
            R.drawable.don_quijote
        ));

        libros.add(new Libro(
            "1984",
            "George Orwell",
            1949,
            "Una distopía que presenta un futuro totalitario donde el Gran Hermano vigila cada movimiento de los ciudadanos.",
            R.drawable.mil_novecientos_ochenta_cuatro
        ));

        libros.add(new Libro(
            "El Principito",
            "Antoine de Saint-Exupéry",
            1943,
            "La historia de un pequeño príncipe que viaja de planeta en planeta y sus reflexiones sobre la vida, el amor y la amistad.",
            R.drawable.el_principito
        ));

        libros.add(new Libro(
            "Orgullo y prejuicio",
            "Jane Austen",
            1813,
            "Una novela romántica que sigue la relación entre Elizabeth Bennet y el orgulloso Sr. Darcy en la Inglaterra del siglo XIX.",
            R.drawable.orgullo_prejuicio
        ));

        libros.add(new Libro(
            "Harry Potter y la piedra filosofal",
            "J.K. Rowling",
            1997,
            "La primera aventura del joven mago Harry Potter en el mundo mágico de Hogwarts.",
            R.drawable.harry_potter
        ));
    }

    public Libro buscarLibroPorNombre(String nombre) {
        for (Libro libro : libros) {
            if (libro.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                return libro;
            }
        }
        return null;
    }

    public List<Libro> getAllLibros() {
        return new ArrayList<>(libros);
    }
}
