package com.yates.proyecto_yates.model.dto;

import com.yates.proyecto_yates.model.entity.TipoYateEntity;
import java.util.ArrayList;
import java.util.List;

public class TipoYateDTO {

    private Long num_tipo_yate;
    private String nombre;
    private String descripcion;

    public TipoYateDTO() {
    }

    public TipoYateDTO(Long id_tipo, String nombre, String descripcion) {
        this.num_tipo_yate = id_tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public static TipoYateDTO fromEntity(TipoYateEntity entity) {
        return new TipoYateDTO(
                entity.getNum_tipo_yate(),
                entity.getNombre(),
                entity.getDescripcion()
        );
    }

    public static List<TipoYateDTO> fromEntityList(List<TipoYateEntity> entities) {
        List<TipoYateDTO> dtos = new ArrayList<>();

        for (TipoYateEntity entity : entities) {
            dtos.add(fromEntity(entity));
        }

        return dtos;
    }

    public Long getId_tipo() {
        return num_tipo_yate;
    }

    public void setId_tipo(Long id_tipo) {
        this.num_tipo_yate = id_tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
