package com.example.backendprueba.controller;

import com.example.backendprueba.dto.Mensaje;
import com.example.backendprueba.dto.TareaDto;
import com.example.backendprueba.entity.Tarea;
import com.example.backendprueba.security.entity.Usuario;
import com.example.backendprueba.security.service.UsuarioServices;
import com.example.backendprueba.service.TareaServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarea")
@CrossOrigin(origins = "*")
@Slf4j
public class TareaController {

    @Autowired
    TareaServices tareaServices;

    @Autowired
    UsuarioServices usuarioServices;

    @GetMapping("/all/{nombre}")
    public ResponseEntity<Optional<Tarea>> listar(@PathVariable("nombre") String nombre){
        log.info("ingreso variable: "+nombre);
        Usuario usuario = usuarioServices.getByNombreUsuario(nombre).get();
        log.info("datos "+usuario.getId());
        int userId = usuario.getId();
        log.info("el dato es este "+userId);
        List<Tarea> list = tareaServices.listPorNombrre(userId);
        log.warn("la lista "+list);
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/allAdmin")
    public ResponseEntity<List<Tarea>> listarTodos(){
        List<Tarea> list = tareaServices.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody TareaDto tareaDto){
        Usuario usuario = usuarioServices.getByNombreUsuario(tareaDto.getNombreUsuario()).get();
        Tarea tarea = new Tarea(tareaDto.getNombre(),tareaDto.isFinalizado(),tareaDto.getFechaVencimiento(),usuario);
        tareaServices.save(tarea);
        return new ResponseEntity(new Mensaje("Tarea creada"), HttpStatus.OK);
    }


    @PostMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody TareaDto tareaDto){
        if(!tareaServices.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Tarea tarea = tareaServices.getOne(id).get();
        tarea.setFinalizado(tareaDto.isFinalizado());
        tarea.setNombre(tareaDto.getNombre());
        tarea.setFechaVencimiento(tareaDto.getFechaVencimiento());
        tareaServices.save(tarea);
        return new ResponseEntity(new Mensaje("Tarea creada"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!tareaServices.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        tareaServices.delete(id);
        return new ResponseEntity(new Mensaje("tarea eliminada"), HttpStatus.OK);
    }

}
