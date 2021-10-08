package com.example.backendprueba.security.service;

import com.example.backendprueba.security.entity.Rol;
import com.example.backendprueba.security.entity.Usuario;
import com.example.backendprueba.security.enums.RolNombre;
import com.example.backendprueba.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RolServices {

    @Autowired
    RolRepository rolRepository;


    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }
    public void save(Rol rol){
        rolRepository.save(rol);
    }

}
