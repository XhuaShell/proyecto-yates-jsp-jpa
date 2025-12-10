package com.yates.proyecto_yates.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "yates")
public class YateEntity {

    @Id
    private String matricula;
    
    @Column(unique = true)
    private String nombre;
    
    private String color;
    private Double eslora;
    private Double manga;
    private Double calado;

    @ManyToOne
    @JoinColumn(name = "cedula_dueno", referencedColumnName = "cedula", nullable = true)
    private UsuarioEntity dueno;

    @ManyToOne(optional = false)
    @JoinColumn(name = "num_tipo_yate", nullable = false)
    private TipoYateEntity tipoYate;

    public YateEntity() {
    }

    public YateEntity(String matricula, String nombre, String color, Double eslora, Double manga, Double calado, UsuarioEntity dueno, TipoYateEntity tipoYate) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.color = color;
        this.eslora = eslora;
        this.manga = manga;
        this.calado = calado;
        this.dueno = dueno;
        this.tipoYate = tipoYate;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getEslora() {
        return eslora;
    }

    public void setEslora(Double eslora) {
        this.eslora = eslora;
    }

    public Double getManga() {
        return manga;
    }

    public void setManga(Double manga) {
        this.manga = manga;
    }

    public Double getCalado() {
        return calado;
    }

    public void setCalado(Double calado) {
        this.calado = calado;
    }

    public UsuarioEntity getDueno() {
        return dueno;
    }

    public void setDueno(UsuarioEntity dueno) {
        this.dueno = dueno;
    }

    public TipoYateEntity getTipoYate() {
        return tipoYate;
    }

    public void setTipoYate(TipoYateEntity tipoYate) {
        this.tipoYate = tipoYate;
    }

}
