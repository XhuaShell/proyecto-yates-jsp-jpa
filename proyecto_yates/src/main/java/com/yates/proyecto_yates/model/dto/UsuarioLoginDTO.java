package com.yates.proyecto_yates.model.dto;

public class UsuarioLoginDTO {

    private String email;
    private String contrasena;

    public UsuarioLoginDTO() {
    }

    public UsuarioLoginDTO(String email, String contrasena) {
        this.email = email;
        this.contrasena = contrasena;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}