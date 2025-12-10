package com.yates.proyecto_yates.model.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "zonas")
public class ZonaEntity {

    @Id
    private Character id_zona;

    @Basic
    private Double cuota_administracion;
    private Integer capacidad;
    private Double profundidad;
    private Double dim_max_eslora;
    private Double dim_max_manga;
    private Double dim_max_calado;
    private Double dim_min_eslora;
    private Double dim_min_manga;
    private Double dim_min_calado;

    @OneToMany(mappedBy = "zona") // 'mappedBy' apunta al campo en AmarreEntity que tiene la FK
    private Set<AmarreEntity> amarres; // Un Set es mejor si no quieres duplicados

    public ZonaEntity() {
    }

    public ZonaEntity(Character id_zona, Double cuota_administracion, Integer capacidad, Double profundidad, Double dim_max_eslora, Double dim_max_manga, Double dim_max_calado, Double dim_min_eslora, Double dim_min_manga, Double dim_min_calado, Set<AmarreEntity> amarres) {
        this.id_zona = id_zona;
        this.cuota_administracion = cuota_administracion;
        this.capacidad = capacidad;
        this.profundidad = profundidad;
        this.dim_max_eslora = dim_max_eslora;
        this.dim_max_manga = dim_max_manga;
        this.dim_max_calado = dim_max_calado;
        this.dim_min_eslora = dim_min_eslora;
        this.dim_min_manga = dim_min_manga;
        this.dim_min_calado = dim_min_calado;
        this.amarres = amarres;
    }

    public Character getId_zona() {
        return id_zona;
    }

    public void setId_zona(Character id_zona) {
        this.id_zona = id_zona;
    }

    public Double getCuota_administracion() {
        return cuota_administracion;
    }

    public void setCuota_administracion(Double cuota_administracion) {
        this.cuota_administracion = cuota_administracion;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Double getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(Double profundidad) {
        this.profundidad = profundidad;
    }

    public Double getDim_max_eslora() {
        return dim_max_eslora;
    }

    public void setDim_max_eslora(Double dim_max_eslora) {
        this.dim_max_eslora = dim_max_eslora;
    }

    public Double getDim_max_manga() {
        return dim_max_manga;
    }

    public void setDim_max_manga(Double dim_max_manga) {
        this.dim_max_manga = dim_max_manga;
    }

    public Double getDim_max_calado() {
        return dim_max_calado;
    }

    public void setDim_max_calado(Double dim_max_calado) {
        this.dim_max_calado = dim_max_calado;
    }

    public Double getDim_min_eslora() {
        return dim_min_eslora;
    }

    public void setDim_min_eslora(Double dim_min_eslora) {
        this.dim_min_eslora = dim_min_eslora;
    }

    public Double getDim_min_manga() {
        return dim_min_manga;
    }

    public void setDim_min_manga(Double dim_min_manga) {
        this.dim_min_manga = dim_min_manga;
    }

    public Double getDim_min_calado() {
        return dim_min_calado;
    }

    public void setDim_min_calado(Double dim_min_calado) {
        this.dim_min_calado = dim_min_calado;
    }

    public Set<AmarreEntity> getAmarres() {
        return amarres;
    }

    public void setAmarres(Set<AmarreEntity> amarres) {
        this.amarres = amarres;
    }

}
