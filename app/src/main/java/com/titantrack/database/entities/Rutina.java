package com.titantrack.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "rutinas")
public class Rutina {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_rutina")
    private int id;

    @ColumnInfo(name = "nombre_rutina")
    private String nombre;

    @ColumnInfo(name = "descripcion")
    private String descripcion;

    @ColumnInfo(name = "duracion_min") // Mismo nombre que en el diagrama Draw.io
    private int duracionMin;

    @ColumnInfo(name = "nivel_dificultad")
    private String nivelDificultad;

    public Rutina(String nombre, String descripcion, int duracionMin, String nivelDificultad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracionMin = duracionMin;
        this.nivelDificultad = nivelDificultad;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getDuracionMin() { return duracionMin; }
    public void setDuracionMin(int duracionMin) { this.duracionMin = duracionMin; }

    public String getNivelDificultad() { return nivelDificultad; }
    public void setNivelDificultad(String nivelDificultad) { this.nivelDificultad = nivelDificultad; }
}