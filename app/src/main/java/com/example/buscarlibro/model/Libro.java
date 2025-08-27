package com.example.buscarlibro.model;

public class Libro {
    private String nombre;
    private String autor;
    private int anoEdicion;
    private String resena;
    private int imagenResourceId;

    public Libro(String nombre, String autor, int anoEdicion, String resena, int imagenResourceId) {
        this.nombre = nombre;
        this.autor = autor;
        this.anoEdicion = anoEdicion;
        this.resena = resena;
        this.imagenResourceId = imagenResourceId;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoEdicion() {
        return anoEdicion;
    }

    public String getResena() {
        return resena;
    }

    public int getImagenResourceId() {
        return imagenResourceId;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnoEdicion(int anoEdicion) {
        this.anoEdicion = anoEdicion;
    }

    public void setResena(String resena) {
        this.resena = resena;
    }

    public void setImagenResourceId(int imagenResourceId) {
        this.imagenResourceId = imagenResourceId;
    }
}
