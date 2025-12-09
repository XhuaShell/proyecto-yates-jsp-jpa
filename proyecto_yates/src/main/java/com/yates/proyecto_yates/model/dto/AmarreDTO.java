/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yates.proyecto_yates.model.dto;

import java.time.LocalDate;

/**
 *
 * @author krate
 */
public class AmarreDTO {

    private Long num_amarre;
    private char id_zona;
    private String usuario_propietario_cedula;
    private LocalDate fecha_compra;

    public AmarreDTO() {
    }
    

    public AmarreDTO(Long num_amarre, char id_zona, String usuario_propietario_cedula, LocalDate fecha_compra) {
        this.num_amarre = num_amarre;
        this.id_zona = id_zona;
        this.usuario_propietario_cedula = usuario_propietario_cedula;
        this.fecha_compra = fecha_compra;
    }

    public Long getNum_amarre() {
        return num_amarre;
    }

    public void setNum_amarre(Long num_amarre) {
        this.num_amarre = num_amarre;
    }

    public char getId_zona() {
        return id_zona;
    }

    public void setId_zona(char id_zona) {
        this.id_zona = id_zona;
    }

    public String getUsuario_propietario_cedula() {
        return usuario_propietario_cedula;
    }

    public void setUsuario_propietario_cedula(String usuario_propietario_cedula) {
        this.usuario_propietario_cedula = usuario_propietario_cedula;
    }

    public LocalDate getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(LocalDate fecha_compra) {
        this.fecha_compra = fecha_compra;
    }
    
}
