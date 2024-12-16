package com.dam.albertogalvez.model;

public class Libro {


        private Long id;


        private String titulo;


        private Autor autor;




        public Libro() {
        }

        public Libro(String titulo, Long id) {
            this.titulo = titulo;
            this.id = id;
        }

        public Autor getAutor() {
            return autor;
        }

        public void setAutor(Autor autor) {
            this.autor = autor;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        @Override
        public String toString() {
            return "Libro{" +
                    "autor=" + autor +
                    ", id=" + id +
                    ", titulo='" + titulo + '\'' +
                    '}';
        }


}
