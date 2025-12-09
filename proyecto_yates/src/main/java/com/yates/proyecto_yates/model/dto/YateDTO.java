/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yates.proyecto_yates.model.dto;

/**
 *
 * @author krate
 */
public class YateDTO {

    private String matricula;
    private String nombre;
    private double eslora;
    private double manga;
    private double calado;
    private String usuario_dueno_cedula;
    private Long id_tipo;

    public YateDTO() {
    }
    
    public YateDTO(String matricula, String nombre, double eslora, double manga, double calado, String usuario_dueno_cedula, Long id_tipo) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.eslora = eslora;
        this.manga = manga;
        this.calado = calado;
        this.usuario_dueno_cedula = usuario_dueno_cedula;
        this.id_tipo = id_tipo;
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

    public double getEslora() {
        return eslora;
    }

    public void setEslora(double eslora) {
        this.eslora = eslora;
    }

    public double getManga() {
        return manga;
    }

    public void setManga(double manga) {
        this.manga = manga;
    }

    public double getCalado() {
        return calado;
    }

    public void setCalado(double calado) {
        this.calado = calado;
    }

    public String getUsuario_dueno_cedula() {
        return usuario_dueno_cedula;
    }

    public void setUsuario_dueno_cedula(String usuario_dueno_cedula) {
        this.usuario_dueno_cedula = usuario_dueno_cedula;
    }

    public Long getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(Long id_tipo) {
        this.id_tipo = id_tipo;
    }
    
    
}
