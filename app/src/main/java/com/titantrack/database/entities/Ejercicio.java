package com.titantrack.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "ejercicios",
        foreignKeys = @ForeignKey(
                entity = Rutina.class,
                parentColumns = "id_rutina",
                childColumns = "id_rutina",
                onDelete = ForeignKey.CASCADE
        ),
        indices = {@Index("id_rutina")}
)
public class Ejercicio {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_ejercicio")
    private int id;

    @ColumnInfo(name = "id_rutina")
    private int rutinaId;

    @ColumnInfo(name = "nombre_ejercicio")
    private String nombre;

    @ColumnInfo(name = "grupo_muscular")
    private String grupoMuscular;

    @ColumnInfo(name = "series")
    private int series;

    @ColumnInfo(name = "repeticiones")
    private int repeticiones;

    public Ejercicio(int rutinaId, String nombre, String grupoMuscular, int series, int repeticiones) {
        this.rutinaId = rutinaId;
        this.nombre = nombre;
        this.grupoMuscular = grupoMuscular;
        this.series = series;
        this.repeticiones = repeticiones;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getRutinaId() { return rutinaId; }
    public void setRutinaId(int rutinaId) { this.rutinaId = rutinaId; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getGrupoMuscular() { return grupoMuscular; }
    public void setGrupoMuscular(String grupoMuscular) { this.grupoMuscular = grupoMuscular; }

    public int getSeries() { return series; }
    public void setSeries(int series) { this.series = series; }

    public int getRepeticiones() { return repeticiones; }
    public void setRepeticiones(int repeticiones) { this.repeticiones = repeticiones; }
}