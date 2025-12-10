package com.yates.proyecto_yates.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_yate")
public class TipoYateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY es más recomendable
    private Long num_tipo_yate;

    @Column(unique = true)
    private String nombre;
    private String descripcion;

    public TipoYateEntity() {
    }

    public TipoYateEntity(Long num_tipo_yate, String nombre, String descripcion) {
        this.num_tipo_yate = num_tipo_yate;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Long getNum_tipo_yate() {
        return num_tipo_yate;
    }

    public void setNum_tipo_yate(Long num_tipo_yate) {
        this.num_tipo_yate = num_tipo_yate;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
