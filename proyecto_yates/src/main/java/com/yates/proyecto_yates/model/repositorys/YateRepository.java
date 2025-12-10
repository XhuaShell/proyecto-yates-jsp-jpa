package com.yates.proyecto_yates.model.repositorys;

import com.yates.proyecto_yates.model.dto.YateDTO;
import com.yates.proyecto_yates.model.entity.YateEntity;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class YateRepository implements CrudRepository<YateDTO, String> {

    private final EntityManager em;

    public YateRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<YateDTO> listar() {
        List<YateEntity> entities = em
                .createQuery("SELECT y FROM YateEntity y", YateEntity.class)
                .getResultList();

        List<YateDTO> dtos = new ArrayList<>();
        for (YateEntity entity : entities) {
            dtos.add(YateDTO.fromEntity(entity));
        }

        return dtos;
    }

    @Override
    public YateDTO porId(String matricula) {
        YateEntity entity = em.find(YateEntity.class, matricula);
        return entity != null ? YateDTO.fromEntity(entity) : null;
    }

    @Override
    public void guardar(YateDTO dto) {
        YateEntity entity = dto.toEntity(em);
        em.merge(entity);  // merge inserta o actualiza
    }

    @Override
    public void eliminar(String matricula) {
        YateEntity entity = em.find(YateEntity.class, matricula);
        if (entity != null) {
            em.remove(entity);
        }
    }
}
