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
import java.time.LocalDateTime;

/**
 *
 * @author krate
 */

@Entity
@Table(name="asignacion_amarre") 
public class AsignacionAmarreEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id_asignacion;
    
    private String matricula_yate;
    private Long num_amarre;
    private LocalDateTime fecha_inicio;
    private LocalDateTime fecha_fin;
    private double monto;
    private String usuario_solicitante_cedula;
    private String tipo_asignacion;

    public AsignacionAmarreEntity(Long id_asignacion, String matricula_yate, Long num_amarre, LocalDateTime fecha_inicio, LocalDateTime fecha_fin, double monto, String usuario_solicitante_cedula, String tipo_asignacion) {
        this.id_asignacion = id_asignacion;
        this.matricula_yate = matricula_yate;
        this.num_amarre = num_amarre;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.monto = monto;
        this.usuario_solicitante_cedula = usuario_solicitante_cedula;
        this.tipo_asignacion = tipo_asignacion;
    }

    public Long getId_asignacion() {
        return id_asignacion;
    }

    public void setId_asignacion(Long id_asignacion) {
        this.id_asignacion = id_asignacion;
    }

    public String getMatricula_yate() {
        return matricula_yate;
    }

    public void setMatricula_yate(String matricula_yate) {
        this.matricula_yate = matricula_yate;
    }

    public Long getNum_amarre() {
        return num_amarre;
    }

    public void setNum_amarre(Long num_amarre) {
        this.num_amarre = num_amarre;
    }

    public LocalDateTime getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDateTime fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDateTime getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDateTime fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getUsuario_solicitante_cedula() {
        return usuario_solicitante_cedula;
    }

    public void setUsuario_solicitante_cedula(String usuario_solicitante_cedula) {
        this.usuario_solicitante_cedula = usuario_solicitante_cedula;
    }

    public String getTipo_asignacion() {
        return tipo_asignacion;
    }

    public void setTipo_asignacion(String tipo_asignacion) {
        this.tipo_asignacion = tipo_asignacion;
    }
        
            
}
