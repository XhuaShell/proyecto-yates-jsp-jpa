package com.yates.proyecto_yates.model.repositorys;

import java.util.List;

public interface CrudRepository<T, ID> {
    List<T> listar();
    T porId(ID id);
    void guardar(T t);
    void eliminar(ID id);
}
