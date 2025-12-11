package com.yates.proyecto_yates.model.dto;

import com.yates.proyecto_yates.model.entity.ZonaEntity;
import java.util.ArrayList;
import java.util.List;

public class ZonaDTO {

    private Character id_zona;
    private Double cuota_administracion;
    private Integer capacidad;
    private Double profundidad;
    private Double dim_max_eslora;
    private Double dim_max_manga;
    private Double dim_max_calado;
    private Double dim_min_eslora;
    private Double dim_min_manga;
    private Double dim_min_calado;

    public ZonaDTO() {
    }

    public ZonaDTO(Character id_zona, Double cuota_administracion, Integer capacidad, Double profundidad, Double dim_max_eslora, Double dim_max_manga, Double dim_max_calado, Double dim_min_eslora, Double dim_min_manga, Double dim_min_calado) {
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
    }

    public static ZonaDTO fromEntity(ZonaEntity entity) {
        if (entity == null) {
            return null;
        }

        return new ZonaDTO(
                entity.getId_zona(),
                entity.getCuota_administracion(),
                entity.getCapacidad(),
                entity.getProfundidad(),
                entity.getDim_max_eslora(),
                entity.getDim_max_manga(),
                entity.getDim_max_calado(),
                entity.getDim_min_eslora(),
                entity.getDim_min_manga(),
                entity.getDim_min_calado()
        );
    }

    public Character getId_zona() {
        return id_zona;
    }

    public void setId_zona(Character id_zona) {
        this.id_zona = id_zona;
    }
    
    public static List<ZonaDTO> fromEntityList(List<ZonaEntity> entities) {
        List<ZonaDTO> dtos = new ArrayList<>();

        if (entities == null) {
            return dtos;
        }

        for (ZonaEntity entity : entities) {
            dtos.add(fromEntity(entity));
        }

        return dtos;
    }

    public ZonaEntity toEntity() {
        ZonaEntity entity = new ZonaEntity();

        entity.setId_zona(this.id_zona);
        entity.setCuota_administracion(this.cuota_administracion);
        entity.setCapacidad(this.capacidad);
        entity.setProfundidad(this.profundidad);
        entity.setDim_max_eslora(this.dim_max_eslora);
        entity.setDim_max_manga(this.dim_max_manga);
        entity.setDim_max_calado(this.dim_max_calado);
        entity.setDim_min_eslora(this.dim_min_eslora);
        entity.setDim_min_manga(this.dim_min_manga);
        entity.setDim_min_calado(this.dim_min_calado);

        return entity;
    }

    public double getCuota_administracion() {
        return cuota_administracion;
    }

    public void setCuota_administracion(double cuota_administracion) {
        this.cuota_administracion = cuota_administracion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }

    public double getDim_max_eslora() {
        return dim_max_eslora;
    }

    public void setDim_max_eslora(double dim_max_eslora) {
        this.dim_max_eslora = dim_max_eslora;
    }

    public double getDim_max_manga() {
        return dim_max_manga;
    }

    public void setDim_max_manga(double dim_max_manga) {
        this.dim_max_manga = dim_max_manga;
    }

    public double getDim_max_calado() {
        return dim_max_calado;
    }

    public void setDim_max_calado(double dim_max_calado) {
        this.dim_max_calado = dim_max_calado;
    }

    public double getDim_min_eslora() {
        return dim_min_eslora;
    }

    public void setDim_min_eslora(double dim_min_eslora) {
        this.dim_min_eslora = dim_min_eslora;
    }

    public double getDim_min_manga() {
        return dim_min_manga;
    }

    public void setDim_min_manga(double dim_min_manga) {
        this.dim_min_manga = dim_min_manga;
    }

    public double getDim_min_calado() {
        return dim_min_calado;
    }

    public void setDim_min_calado(double dim_min_calado) {
        this.dim_min_calado = dim_min_calado;
    }

}
