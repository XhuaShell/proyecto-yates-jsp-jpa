package com.yates.proyecto_yates.model.dto;

import com.yates.proyecto_yates.model.entity.ZonaEntity;
import java.util.ArrayList;
import java.util.List;

public class ZonaDTO {

    private double cuota_administracion;
    private int capacidad;
    private double profundidad;
    private double dim_max_eslora;
    private double dim_max_manga;
    private double dim_max_calado;
    private double dim_min_eslora;
    private double dim_min_manga;
    private double dim_min_calado;

    public ZonaDTO() {
    }

    public ZonaDTO(double cuota_administracion, int capacidad, double profundidad, double dim_max_eslora, double dim_max_manga, double dim_max_calado, double dim_min_eslora, double dim_min_manga, double dim_min_calado) {
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
