package com.example.backendprueba.dto;

import com.example.backendprueba.security.entity.Usuario;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class TareaDto {

    @NotBlank
    private String nombre;
    @NotBlank
    private Date fechaCreacion;
    private boolean finalizado;
    @NotBlank
    private Date fechaVencimiento;
    @NotBlank
    private String nombreUsuario;


    public TareaDto() {
    }

    public TareaDto(String nombre, boolean finalizado, Date fechaVencimiento,String nombreUsuario,Date fechaCreacion) {
        this.nombre = nombre;
        this.finalizado = finalizado;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaCreacion = fechaCreacion;
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }


    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}

