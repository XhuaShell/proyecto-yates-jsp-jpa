package com.yates.proyecto_yates.model.repositorys;

import com.yates.proyecto_yates.model.dto.UsuarioDTO;
import com.yates.proyecto_yates.model.dto.UsuarioLoginDTO;
import com.yates.proyecto_yates.model.entity.UsuarioEntity;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository implements CrudRepository<UsuarioDTO, String> {

    private final EntityManager em;

    public UsuarioRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<UsuarioDTO> listar() {
        List<UsuarioEntity> entities = em
                .createQuery("SELECT u FROM UsuarioEntity u", UsuarioEntity.class)
                .getResultList();

        List<UsuarioDTO> dtos = new ArrayList<>();
        for (UsuarioEntity entity : entities) {
            dtos.add(UsuarioDTO.fromEntity(entity));
        }

        return dtos;
    }

    @Override
    public UsuarioDTO porId(String id) {
        UsuarioEntity entity = em.find(UsuarioEntity.class, id);
        return entity != null ? UsuarioDTO.fromEntity(entity) : null;
    }

    @Override
    public void guardar(UsuarioDTO dto) {
        UsuarioEntity entity = dto.toEntity();
        em.merge(entity); // merge sirve para INSERT o UPDATE
    }

    @Override
    public void eliminar(String id) {
        UsuarioEntity entity = em.find(UsuarioEntity.class, id);
        if (entity != null) {
            em.remove(entity);
        }
    }

    public UsuarioDTO validarCredenciales(UsuarioLoginDTO ulogin) {
        try {
            UsuarioEntity user = this.em.createQuery(
                    "SELECT u FROM UsuarioEntity u WHERE u.mail = :mail AND u.contrasena = :pass",
                    UsuarioEntity.class)
                    .setParameter("mail", ulogin.getEmail())
                    .setParameter("pass", ulogin.getContrasena())
                    .getSingleResult();

            return UsuarioDTO.fromEntity(user);
        } catch (jakarta.persistence.NoResultException e) {
            return null;
        }
    }
}
