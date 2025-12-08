package com.yates.proyecto_yates.model.entity;

import java.time.LocalDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author krate
 */
public class VentaEntity {
    private Long num_venta;
    private LocalDate fecha;
    private double monto; 
    private Long num_amarre;
    private String vendedor_cedula;
    private String comprador_cedula;

    public VentaEntity(Long num_venta, LocalDate fecha, double monto, Long num_amarre, String vendedor_cedula, String comprador_cedula) {
        this.num_venta = num_venta;
        this.fecha = fecha;
        this.monto = monto;
        this.num_amarre = num_amarre;
        this.vendedor_cedula = vendedor_cedula;
        this.comprador_cedula = comprador_cedula;
    }

    public Long getNum_venta() {
        return num_venta;
    }

    public void setNum_venta(Long num_venta) {
        this.num_venta = num_venta;
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

    public Long getNum_amarre() {
        return num_amarre;
    }

    public void setNum_amarre(Long num_amarre) {
        this.num_amarre = num_amarre;
    }

    public String getVendedor_cedula() {
        return vendedor_cedula;
    }

    public void setVendedor_cedula(String vendedor_cedula) {
        this.vendedor_cedula = vendedor_cedula;
    }

    public String getComprador_cedula() {
        return comprador_cedula;
    }

    public void setComprador_cedula(String comprador_cedula) {
        this.comprador_cedula = comprador_cedula;
    }
    
}
