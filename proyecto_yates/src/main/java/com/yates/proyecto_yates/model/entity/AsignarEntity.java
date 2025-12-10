package com.yates.proyecto_yates.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "asignar")
public class AsignarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_asignacion;

    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private Double monto;
    private String tipo_asignacion;

    // Relación con AMARRE -> FK num_amarre
    @ManyToOne(optional = false)
    @JoinColumn(name = "num_amarre", nullable = false)
    private AmarreEntity amarre;

    // Relación con YATE -> FK matricula
    @ManyToOne(optional = false)
    @JoinColumn(name = "matricula", nullable = false)
    private YateEntity yate;

    public AsignarEntity() {
    }

    public AsignarEntity(Long id_asignacion, LocalDate fecha_inicio, LocalDate fecha_fin, Double monto, String tipo_asignacion, AmarreEntity amarre, YateEntity yate) {
        this.id_asignacion = id_asignacion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.monto = monto;
        this.tipo_asignacion = tipo_asignacion;
        this.amarre = amarre;
        this.yate = yate;
    }

    public Long getId_asignacion() {
        return id_asignacion;
    }

    public void setId_asignacion(Long id_asignacion) {
        this.id_asignacion = id_asignacion;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getTipo_asignacion() {
        return tipo_asignacion;
    }

    public void setTipo_asignacion(String tipo_asignacion) {
        this.tipo_asignacion = tipo_asignacion;
    }

    public AmarreEntity getAmarre() {
        return amarre;
    }

    public void setAmarre(AmarreEntity amarre) {
        this.amarre = amarre;
    }

    public YateEntity getYate() {
        return yate;
    }

    public void setYate(YateEntity yate) {
        this.yate = yate;
    }

}
