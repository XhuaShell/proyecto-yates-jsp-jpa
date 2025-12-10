package com.yates.proyecto_yates.model.dto;

import com.yates.proyecto_yates.model.TipoUsuario;
import com.yates.proyecto_yates.model.entity.UsuarioEntity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDTO {

    private String cedula;
    private String nombre;
    private String direccion;
    private String telefono;
    private String mail;
    private LocalDate fechaVinculacion;
    private TipoUsuario tipoUsuario;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String cedula, String nombre, String direccion, String telefono, String mail, LocalDate fechaVinculacion, TipoUsuario tipoUsuario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.mail = mail;
        this.fechaVinculacion = fechaVinculacion;
        this.tipoUsuario = tipoUsuario;
    }

    public static UsuarioDTO fromEntity(UsuarioEntity entity) {
        if (entity == null) {
            return null;
        }

        return new UsuarioDTO(
                entity.getCedula(),
                entity.getNombre(),
                entity.getDireccion(),
                entity.getTelefono(),
                entity.getMail(),
                // LocalDate → Date
                entity.getFechaVinculacion(),
                entity.getTipoUsuario()
        );
    }

    public UsuarioEntity toEntity() {
        UsuarioEntity entity = new UsuarioEntity();

        entity.setCedula(this.cedula);
        entity.setNombre(this.nombre);
        entity.setDireccion(this.direccion);
        entity.setTelefono(this.telefono);
        entity.setMail(this.mail);

        // Date → LocalDate
        if (this.fechaVinculacion != null) {
            entity.setFechaVinculacion(this.fechaVinculacion);
        } else {
            entity.setFechaVinculacion(null);
        }

        entity.setTipoUsuario(this.tipoUsuario);

        return entity;
    }

    public static List<UsuarioDTO> fromEntityList(List<UsuarioEntity> entities) {
        List<UsuarioDTO> dtos = new ArrayList<>();

        if (entities == null) {
            return dtos;
        }

        for (UsuarioEntity entity : entities) {
            dtos.add(fromEntity(entity));
        }

        return dtos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDate getFechaVinculacion() {
        return fechaVinculacion;
    }

    public void setFechaVinculacion(LocalDate fechaVinculacion) {
        this.fechaVinculacion = fechaVinculacion;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

}
