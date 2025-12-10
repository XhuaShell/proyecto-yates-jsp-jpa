package com.yates.proyecto_yates.model.repositorys;

import com.yates.proyecto_yates.model.dto.TipoYateDTO;
import com.yates.proyecto_yates.model.entity.TipoYateEntity;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class TipoYateRepository implements CrudRepository<TipoYateDTO, Long> {

    private final EntityManager em;

    public TipoYateRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<TipoYateDTO> listar() {
        List<TipoYateEntity> entities = em
                .createQuery("SELECT t FROM TipoYateEntity t", TipoYateEntity.class)
                .getResultList();

        List<TipoYateDTO> dtos = new ArrayList<>();
        for (TipoYateEntity entity : entities) {
            dtos.add(TipoYateDTO.fromEntity(entity));
        }

        return dtos;
    }

    @Override
    public TipoYateDTO porId(Long id) {
        TipoYateEntity entity = em.find(TipoYateEntity.class, id);
        return entity != null ? TipoYateDTO.fromEntity(entity) : null;
    }

    @Override
    public void guardar(TipoYateDTO dto) {
        TipoYateEntity entity = dto.toEntity();
        em.merge(entity);  // merge → INSERT si id es null, UPDATE si existe
    }

    @Override
    public void eliminar(Long id) {
        TipoYateEntity entity = em.find(TipoYateEntity.class, id);
        if (entity != null) {
            em.remove(entity);
        }
    }
}
