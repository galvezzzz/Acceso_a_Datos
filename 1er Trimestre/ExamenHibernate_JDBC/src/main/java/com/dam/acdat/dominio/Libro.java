package com.dam.acdat.dominio;

public class Libro {
    private int id;
    private String titulo;
    private int autorId;

    public Libro() {}

    public Libro(String titulo, int autorId) {
        this.titulo = titulo;
        this.autorId = autorId;
    }

    public Libro(int id, String titulo, int autorId) {
        this.id = id;
        this.titulo = titulo;
        this.autorId = autorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAutorId() {
        return autorId;
    }

    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autorId=" + autorId +
                '}';
    }
}
