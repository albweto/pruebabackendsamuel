package com.example.backendprueba.service;

import com.example.backendprueba.entity.Tarea;
import com.example.backendprueba.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional

public class TareaServices {

    @Autowired
    TareaRepository tareaRepository;


    public List<Tarea> list(){
        return tareaRepository.findAll();
    }
    public List<Tarea> listPorNombrre(int id){
        return tareaRepository.findAllByUsuario(id);
    }

    public Optional<Tarea> getOne(int id){
        return tareaRepository.findById(id);
    }



    public void  save(Tarea producto){
        tareaRepository.save(producto);
    }

    public void delete(int id){
        tareaRepository.deleteById(id);
    }
    public boolean existsById(int id){
        return tareaRepository.existsById(id);
    }
}
