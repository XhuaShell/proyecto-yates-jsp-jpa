package com.yates.proyecto_yates.model.repositorys;

import com.yates.proyecto_yates.model.dto.ZonaDTO;
import com.yates.proyecto_yates.model.entity.ZonaEntity;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class ZonaRepository implements CrudRepository<ZonaDTO, Character> {

    private final EntityManager em;

    public ZonaRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<ZonaDTO> listar() {
        List<ZonaEntity> entities = em
                .createQuery("SELECT z FROM ZonaEntity z", ZonaEntity.class)
                .getResultList();

        List<ZonaDTO> dtos = new ArrayList<>();
        for (ZonaEntity entity : entities) {
            dtos.add(ZonaDTO.fromEntity(entity));
        }

        return dtos;
    }

    @Override
    public ZonaDTO porId(Character id) {
        ZonaEntity entity = em.find(ZonaEntity.class, id);
        return entity != null ? ZonaDTO.fromEntity(entity) : null;
    }

    @Override
    public void guardar(ZonaDTO dto) {
        ZonaEntity entity = dto.toEntity();
        em.merge(entity); // merge hace INSERT o UPDATE automático
    }

    @Override
    public void eliminar(Character id) {
        ZonaEntity entity = em.find(ZonaEntity.class, id);
        if (entity != null) {
            em.remove(entity);
        }
    }
}
