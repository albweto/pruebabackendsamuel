package com.example.backendprueba.repository;

import com.example.backendprueba.entity.Tarea;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer> {
    @Query("select t from Tarea t where t.usuario.id = :id ")
    List<Tarea> findAllByUsuario(@Param("id") int id);
}
