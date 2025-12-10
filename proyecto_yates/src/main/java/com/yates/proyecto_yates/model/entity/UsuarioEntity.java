package com.yates.proyecto_yates.model.entity;

import com.yates.proyecto_yates.model.TipoUsuario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class UsuarioEntity {

    @Id
    private String cedula;

    private String nombre;
    private String direccion;
    private String telefono;
    private String contrasena;

    @Column(unique = true)
    private String mail;

    @Column(name = "fecha_vinculacion")
    private LocalDate fechaVinculacion;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario", nullable = false)
    private TipoUsuario tipoUsuario;

    @OneToMany(mappedBy = "dueno")
    private List<YateEntity> yatesPropios;

    // Ventas donde este usuario fue el VENDEDOR
    @OneToMany(mappedBy = "vendedor")
    private List<VentaEntity> ventasRealizadas;

    // Ventas donde este usuario fue el COMPRADOR
    @OneToMany(mappedBy = "comprador")
    private List<VentaEntity> comprasRealizadas;

    public UsuarioEntity() {
    }

    public UsuarioEntity(String cedula, String nombre, String direccion, String telefono, String contrasena, String mail, LocalDate fechaVinculacion, TipoUsuario tipoUsuario, List<YateEntity> yatesPropios) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.mail = mail;
        this.fechaVinculacion = fechaVinculacion;
        this.tipoUsuario = tipoUsuario;
        this.yatesPropios = yatesPropios;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDate getFechaVinculacion() {
        return fechaVinculacion;
    }

    public void setFechaVinculacion(LocalDate fechaVinculacion) {
        this.fechaVinculacion = fechaVinculacion;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public List<YateEntity> getYatesPropios() {
        return yatesPropios;
    }

    public void setYatesPropios(List<YateEntity> yatesPropios) {
        this.yatesPropios = yatesPropios;
    }

}
