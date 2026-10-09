package com.titantrack.activities;

public class RutinaModel {

    private String titulo;
    private String detalles;

    // Constructor
    public RutinaModel(String titulo, String detalles) {
        this.titulo = titulo;
        this.detalles = detalles;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getDetalles() {
        return detalles;
    }
}