package com.titantrack.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "registros_entrenamiento",
        foreignKeys = {
                @ForeignKey(
                        entity = Usuario.class,
                        parentColumns = "id_user",
                        childColumns = "id_user",
                        onDelete = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = Rutina.class,
                        parentColumns = "id_rutina",
                        childColumns = "id_rutina",
                        onDelete = ForeignKey.CASCADE
                )
        },
        indices = {
                @Index("id_user"),
                @Index("id_rutina")
        }
)
public class RegistroEntrenamiento {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_registro")
    private int id;

    @ColumnInfo(name = "id_user")
    private int idUser;

    @ColumnInfo(name = "id_rutina")
    private int idRutina;

    @ColumnInfo(name = "fecha")
    private String fecha;

    @ColumnInfo(name = "duracion")
    private int duracion;

    @ColumnInfo(name = "peso_levantado")
    private float pesoLevantado;

    public RegistroEntrenamiento(int idUser, int idRutina, String fecha, int duracion, float pesoLevantado) {
        this.idUser = idUser;
        this.idRutina = idRutina;
        this.fecha = fecha;
        this.duracion = duracion;
        this.pesoLevantado = pesoLevantado;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdUser() { return idUser; }
    public void setIdUser(int idUser) { this.idUser = idUser; }

    public int getIdRutina() { return idRutina; }
    public void setIdRutina(int idRutina) { this.idRutina = idRutina; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public int getDuracion() { return duracion; }
    public void setDuracion(int duracion) { this.duracion = duracion; }

    public float getPesoLevantado() { return pesoLevantado; }
    public void setPesoLevantado(float pesoLevantado) { this.pesoLevantado = pesoLevantado; }
}