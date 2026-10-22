package com.titantrack.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "usuarios")
public class Usuario {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_user")
    private int idUser;

    @ColumnInfo(name = "nombre")
    private String nombre;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "password")
    private String password;

    @ColumnInfo(name = "sistema_unidades")
    private String sistemaUnidades;

    public Usuario(String nombre, String email, String password, String sistemaUnidades) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.sistemaUnidades = sistemaUnidades;
    }

    // Getters y Setters
    public int getIdUser() { return idUser; }
    public void setIdUser(int idUser) { this.idUser = idUser; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getSistemaUnidades() { return sistemaUnidades; }
    public void setSistemaUnidades(String sistemaUnidades) { this.sistemaUnidades = sistemaUnidades; }
}