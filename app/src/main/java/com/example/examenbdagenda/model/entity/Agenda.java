package com.example.examenbdagenda.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(tableName = "agenda")
public class Agenda implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "nombre")
    String nombre;

    @NonNull
    @ColumnInfo(name = "apellidos")
    String apellidos;

    @NonNull
    @ColumnInfo(name = "telefono")
    int telefono;

    @NonNull
    @ColumnInfo(name = "fechaNac")
    String fechaNac;

    @NonNull
    @ColumnInfo(name = "localidad")
    String localidad;

    @NonNull
    @ColumnInfo(name = "calle")
    String calle;

    @NonNull
    @ColumnInfo(name = "numero")
    int numero;

    public Agenda() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Agenda(@NonNull String nombre, @NonNull String apellidos, int telefono, @NonNull String fechaNac, @NonNull String localidad, @NonNull String calle, int numero) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.fechaNac = fechaNac;
        this.localidad = localidad;
        this.calle = calle;
        this.numero = numero;
    }

    @NonNull
    public String getNombre() {
        return nombre;
    }

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }

    @NonNull
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(@NonNull String apellidos) {
        this.apellidos = apellidos;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @NonNull
    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(@NonNull String fechaNac) {
        this.fechaNac = fechaNac;
    }

    @NonNull
    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(@NonNull String localidad) {
        this.localidad = localidad;
    }

    @NonNull
    public String getCalle() {
        return calle;
    }

    public void setCalle(@NonNull String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", telefono=" + telefono +
                ", fechaNac=" + fechaNac +
                ", localidad='" + localidad + '\'' +
                ", calle='" + calle + '\'' +
                ", numero=" + numero +
                '}';
    }
}
