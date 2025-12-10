package com.yates.proyecto_yates.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "ventas")
public class VentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num_venta;

    private Double monto;
    private LocalDate fecha;

    // Relación con AMARRES -> FK num_amarre
    @ManyToOne(optional = false)
    @JoinColumn(name = "num_amarre", nullable = false)
    private AmarreEntity amarre;

    // Relación con USUARIOS -> FK codigo_vendedor
    @ManyToOne(optional = false)
    @JoinColumn(name = "cedula_vendedor", referencedColumnName = "cedula",  nullable = false)
    private UsuarioEntity vendedor;

    // Relación con USUARIOS -> FK codigo_comprador
    @ManyToOne(optional = false)
    @JoinColumn(name = "cedula_comprador", referencedColumnName = "cedula", nullable = false)
    private UsuarioEntity comprador;

    public VentaEntity() {
    }

    public VentaEntity(Long num_venta, Double monto, LocalDate fecha, AmarreEntity amarreVendido, UsuarioEntity vendedor, UsuarioEntity comprador) {
        this.num_venta = num_venta;
        this.monto = monto;
        this.fecha = fecha;
        this.amarre = amarreVendido;
        this.vendedor = vendedor;
        this.comprador = comprador;
    }

    public Long getNum_venta() {
        return num_venta;
    }

    public void setNum_venta(Long num_venta) {
        this.num_venta = num_venta;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public AmarreEntity getAmarre() {
        return amarre;
    }

    public void setAmarre(AmarreEntity amarreVendido) {
        this.amarre = amarreVendido;
    }

    public UsuarioEntity getVendedor() {
        return vendedor;
    }

    public void setVendedor(UsuarioEntity vendedor) {
        this.vendedor = vendedor;
    }

    public UsuarioEntity getComprador() {
        return comprador;
    }

    public void setComprador(UsuarioEntity comprador) {
        this.comprador = comprador;
    }
}
