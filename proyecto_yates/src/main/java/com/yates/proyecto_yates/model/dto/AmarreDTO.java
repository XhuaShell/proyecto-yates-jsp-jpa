package com.yates.proyecto_yates.model.dto;

import com.yates.proyecto_yates.model.entity.AmarreEntity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AmarreDTO {

    private Long num_amarre;
    private char id_zona;

    public AmarreDTO() {
    }

    public AmarreDTO(Long num_amarre, char id_zona) {
        this.num_amarre = num_amarre;
        this.id_zona = id_zona;
    }

    public static AmarreDTO fromEntity(AmarreEntity entity) {

        if (entity == null) {
            return null;
        }

        // Datos base
        Long numAmarre = entity.getNum_amarre();
        char idZona = entity.getZona().getId_zona(); // suponiendo que es un CHAR en ZonaEntity

        return new AmarreDTO(
                numAmarre,
                idZona
        );
    }

    public static List<AmarreDTO> fromEntityList(List<AmarreEntity> entities) {
        List<AmarreDTO> dtos = new ArrayList<>();

        if (entities == null) {
            return dtos;
        }

        for (AmarreEntity entity : entities) {
            dtos.add(fromEntity(entity));
        }

        return dtos;
    }

    public Long getNum_amarre() {
        return num_amarre;
    }

    public void setNum_amarre(Long num_amarre) {
        this.num_amarre = num_amarre;
    }

    public char getId_zona() {
        return id_zona;
    }

    public void setId_zona(char id_zona) {
        this.id_zona = id_zona;
    }
}
