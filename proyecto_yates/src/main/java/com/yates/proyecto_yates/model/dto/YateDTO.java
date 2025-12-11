package com.yates.proyecto_yates.model.dto;

import com.yates.proyecto_yates.model.entity.TipoYateEntity;
import com.yates.proyecto_yates.model.entity.UsuarioEntity;
import com.yates.proyecto_yates.model.entity.YateEntity;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class YateDTO {

    private String matricula;
    private String nombre;
    private double eslora;
    private double manga;
    private double calado;
    private String usuario_dueno_cedula;
    private Long id_tipo;  // SOLO EL ID (Long), no la entidad

    public YateDTO() {
    }

    public YateDTO(String matricula, String nombre, double eslora, double manga, 
                   double calado, String usuario_dueno_cedula, Long id_tipo) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.eslora = eslora;
        this.manga = manga;
        this.calado = calado;
        this.usuario_dueno_cedula = usuario_dueno_cedula;
        this.id_tipo = id_tipo;  // Recibe Long directamente
    }

    public static YateDTO fromEntity(YateEntity entity) {
        if (entity == null) {
            return null;
        }

        // Extraer el ID del tipo de yate de la relación
        Long idTipo = null;
        if (entity.getTipoYate() != null) {
            // Obtener el ID del TipoYateEntity
            // Suponiendo que TipoYateEntity tiene un campo "id" (Long)
            idTipo = entity.getTipoYate().getNum_tipo_yate();  // O el getter correcto
        }

        return new YateDTO(
                entity.getMatricula(),
                entity.getNombre(),
                entity.getEslora(),
                entity.getManga(),
                entity.getCalado(),
                entity.getDueno() != null ? entity.getDueno().getCedula() : null,
                idTipo  // Solo el ID (Long)
        );
    }

    public YateEntity toEntity(EntityManager em) {
        YateEntity entity = new YateEntity();

        entity.setMatricula(this.matricula);
        entity.setNombre(this.nombre);
        entity.setEslora(this.eslora);
        entity.setManga(this.manga);
        entity.setCalado(this.calado);

        // Buscar el dueño por cédula
        if (this.usuario_dueno_cedula != null) {
            UsuarioEntity dueno = em.find(UsuarioEntity.class, this.usuario_dueno_cedula);
            entity.setDueno(dueno);
        } else {
            entity.setDueno(null);
        }

        // Buscar el tipo de yate por ID (Long)
        if (this.id_tipo != null) {
            TipoYateEntity tipo = em.find(TipoYateEntity.class, this.id_tipo);
            if (tipo == null) {
                throw new IllegalArgumentException("No se encontró el tipo de yate con ID: " + this.id_tipo);
            }
            entity.setTipoYate(tipo);  // Asignar la entidad completa
        } else {
            throw new IllegalArgumentException("El tipo de yate es obligatorio (id_tipo no puede ser null).");
        }

        return entity;
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

    // Getters y Setters
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

    @Override
    public String toString() {
        return "YateDTO{" +
                "matricula='" + matricula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", eslora=" + eslora +
                ", manga=" + manga +
                ", calado=" + calado +
                ", usuario_dueno_cedula='" + usuario_dueno_cedula + '\'' +
                ", id_tipo=" + id_tipo +
                '}';
    }
}