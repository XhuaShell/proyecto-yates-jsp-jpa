package com.yates.proyecto_yates.model.dto;

import com.yates.proyecto_yates.model.entity.YateEntity;
import java.util.ArrayList;
import java.util.List;

public class YateDTO {

    private String matricula;
    private String nombre;
    private double eslora;
    private double manga;
    private double calado;
    private String usuario_dueno_cedula;
    private TipoYateDTO id_tipo;

    public YateDTO() {
    }

    public YateDTO(String matricula, String nombre, double eslora, double manga, double calado, String usuario_dueno_cedula, TipoYateDTO id_tipo) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.eslora = eslora;
        this.manga = manga;
        this.calado = calado;
        this.usuario_dueno_cedula = usuario_dueno_cedula;
        this.id_tipo = id_tipo;
    }

    public static YateDTO fromEntity(YateEntity entity) {
        if (entity == null) {
            return null;
        }

        return new YateDTO(
                entity.getMatricula(),
                entity.getNombre(),
                entity.getEslora(),
                entity.getManga(),
                entity.getCalado(),
                entity.getDueno() != null ? entity.getDueno().getCedula() : null,
                TipoYateDTO.fromEntity(entity.getTipoYate())
        );
    }

    public static List<YateDTO> fromEntityList(List<YateEntity> entidades) {
        List<YateDTO> dtos = new ArrayList<>();

        if (entidades == null) {
            return dtos;
        }

        for (YateEntity entity : entidades) {
            dtos.add(fromEntity(entity));
        }

        return dtos;
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

    public TipoYateDTO getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(TipoYateDTO id_tipo) {
        this.id_tipo = id_tipo;
    }

}
