/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yates.proyecto_yates.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

/**
 *
 * @author krate
 */
@Entity
@Table(name="usar")
public class UsarEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long cod_servicio;
    private Long num_amarre;
    private LocalDate fecha;
    private double monto;

    public UsarEntity(Long cod_servicio, Long num_amarre, LocalDate fecha, double monto) {
        this.cod_servicio = cod_servicio;
        this.num_amarre = num_amarre;
        this.fecha = fecha;
        this.monto = monto;
    }

    public Long getCod_servicio() {
        return cod_servicio;
    }

    public void setCod_servicio(Long cod_servicio) {
        this.cod_servicio = cod_servicio;
    }

    public Long getNum_amarre() {
        return num_amarre;
    }

    public void setNum_amarre(Long num_amarre) {
        this.num_amarre = num_amarre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
}
