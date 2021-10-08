package com.example.backendprueba.security.jwt;

import com.example.backendprueba.security.entity.UsuarioAdmin;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JwtProvider {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;


    public String generateToken(Authentication authentication){
        UsuarioAdmin usuarioAdmin = (UsuarioAdmin) authentication.getPrincipal();
        return Jwts.builder().setSubject(usuarioAdmin.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    public String getNombreUsuarioFromToken(String token){
        return  Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token){
        log.info("token para validar");
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return  true;

        }catch (MalformedJwtException e){
            log.error("token mal formado");
        }catch (UnsupportedJwtException e){
            log.error("token no soportado");
        }catch (ExpiredJwtException e){
            log.error("token expirado");
        }catch (IllegalArgumentException  e){
            log.error("token vacio");
        }catch (SignatureException  e){
            log.error("fallo en la firma "+e.getMessage());
        }
        return false;
    }
}
