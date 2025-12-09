/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yates.proyecto_yates.model.dto;

/**
 *
 * @author krate
 */
public class TipoYateDTO {
    
    private Long id_tipo;
    private String nombre;
    private String descripcion;

    public TipoYateDTO() {
    }
    
    public TipoYateDTO(Long id_tipo, String nombre, String descripcion) {
        this.id_tipo = id_tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Long getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(Long id_tipo) {
        this.id_tipo = id_tipo;
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
