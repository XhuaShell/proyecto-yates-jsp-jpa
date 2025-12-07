package com.yates.proyecto_yates.service;

import com.yates.proyecto_yates.model.dto.UsuarioDTO;
import com.yates.proyecto_yates.model.dto.UsuarioLoginDTO;
import com.yates.proyecto_yates.model.entity.UsuarioEntity;
import com.yates.proyecto_yates.model.repositorys.CrudRepository;
import com.yates.proyecto_yates.model.repositorys.UsuarioRepository;
import com.yates.proyecto_yates.util.exceptions.AutentificacionException;
import com.yates.proyecto_yates.util.exceptions.UsuarioNoEncontradoException;
import com.yates.proyecto_yates.util.mappers.UsuarioMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class UsuarioService {

    private EntityManager em;
    private CrudRepository<UsuarioEntity, String> repo;

    public UsuarioService(EntityManager em) {
        this.em = em;
        this.repo = new UsuarioRepository(em);
    }

    public UsuarioDTO login(UsuarioLoginDTO usuarioDTO) throws AutentificacionException {
        Query query = this.em.createQuery("SELECT u FROM UsuarioEntity u WHERE u.mail = ?1", UsuarioEntity.class);
        query.setParameter(1, usuarioDTO.getEmail());

        List<UsuarioEntity> resultados = query.getResultList();

        if (resultados.isEmpty()) {
            throw new AutentificacionException("Mail o contraseña incorrectos");
        }

        UsuarioEntity usuario = resultados.get(0);

        if (!usuario.getContrasena().equals(usuarioDTO.getContrasena())) { // Solo para demostración
            throw new AutentificacionException("Mail o contraseña incorrectos");
        }

        return UsuarioMapper.entityToDto(usuario);
    }

    void registrar() {

    }

    void actualizarInfo() {

    }
}
