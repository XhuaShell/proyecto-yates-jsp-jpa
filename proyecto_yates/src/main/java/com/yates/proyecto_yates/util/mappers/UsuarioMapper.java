package com.yates.proyecto_yates.util.mappers;

import com.yates.proyecto_yates.model.dto.UsuarioDTO;
import com.yates.proyecto_yates.model.entity.UsuarioEntity;

public class UsuarioMapper {

    public static UsuarioDTO entityToDto(UsuarioEntity entity) {
        return new UsuarioDTO(
                entity.getCedula(),
                entity.getNombre(),
                entity.getDireccion(),
                entity.getTelefono(),
                entity.getMail(),
                entity.getFechaVinculacion(),
                entity.getTipoUsuario() == 0 ? "ADMIN" : "SOCIO"
        );
    }

    public static UsuarioEntity dtoToEntity(UsuarioDTO dto) {

        int tipoUsuarioInt = dto.getTipoUsuario().equals("ADMIN") ? 0 : 1;
        UsuarioEntity entity = new UsuarioEntity();

        entity.setCedula(dto.getCedula());
        entity.setNombre(dto.getNombre());
        entity.setDireccion(dto.getDireccion());
        entity.setTelefono(dto.getTelefono());
        entity.setMail(dto.getMail());
        entity.setTipoUsuario(tipoUsuarioInt);
        entity.setFechaVinculacion(dto.getFechaVinculacion());

        return entity;
    }

}
