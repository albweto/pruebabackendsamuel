package com.example.backendprueba.util;

import com.example.backendprueba.security.entity.Rol;
import com.example.backendprueba.security.enums.RolNombre;
import com.example.backendprueba.security.service.RolServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RolServices rolService;
    @Override
    public void run(String... args) throws Exception {
       /* Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
        Rol rolUser = new Rol(RolNombre.ROLE_USER);
        rolService.save(rolAdmin);
        rolService.save(rolUser);   */
    }
}
