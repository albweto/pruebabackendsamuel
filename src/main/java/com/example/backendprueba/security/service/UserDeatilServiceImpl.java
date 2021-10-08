package com.example.backendprueba.security.service;

import com.example.backendprueba.security.entity.Usuario;
import com.example.backendprueba.security.entity.UsuarioAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDeatilServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioServices usuarioServices;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioServices.getByNombreUsuario(nombreUsuario).get();
        return UsuarioAdmin.build(usuario);
    }
}
