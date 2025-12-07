package com.yates.proyecto_yates.model.repositorys;

import com.yates.proyecto_yates.model.entity.UsuarioEntity;
import jakarta.persistence.EntityManager;
import java.util.List;

public class UsuarioRepository implements CrudRepository<UsuarioEntity, String> {

    private EntityManager em;

    public UsuarioRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<UsuarioEntity> listar() {
        return em.createQuery("SELECT u FROM usuarios u", UsuarioEntity.class).getResultList();
    }

    @Override
    public UsuarioEntity porId(String id) {
        return em.find(UsuarioEntity.class, id);
    }

    @Override
    public void guardar(UsuarioEntity t) {
        if ( this.porId(t.getCedula()) != null ) {
            em.merge(t);
        } else {
            em.persist(t);
        }
    }

    @Override
    public void eliminar(String id) {
        UsuarioEntity usuario = porId(id);
        em.remove(usuario);
    }
}
