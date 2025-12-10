package com.yates.proyecto_yates.model.repositorys;

import com.yates.proyecto_yates.model.dto.AmarreDTO;
import com.yates.proyecto_yates.model.entity.AmarreEntity;
import jakarta.persistence.EntityManager;

import java.util.List;

public class AmarreRepository implements CrudRepository<AmarreDTO, Long> {

    private final EntityManager em;

    public AmarreRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<AmarreDTO> listar() {
        List<AmarreEntity> entities = em
                .createQuery("SELECT a FROM AmarreEntity a", AmarreEntity.class)
                .getResultList();

        return AmarreDTO.fromEntityList(entities);
    }

    @Override
    public AmarreDTO porId(Long id) {
        AmarreEntity entity = em.find(AmarreEntity.class, id);
        return entity != null ? AmarreDTO.fromEntity(entity) : null;
    }

    @Override
    public void guardar(AmarreDTO dto) {
        AmarreEntity entity = dto.toEntity(em);
        em.merge(entity); // merge para insert/update
    }

    @Override
    public void eliminar(Long id) {
        AmarreEntity entity = em.find(AmarreEntity.class, id);
        if (entity != null) {
            em.remove(entity);
        }
    }
}
