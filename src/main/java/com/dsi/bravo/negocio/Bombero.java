package com.dsi.bravo.negocio;


import com.dsi.bravo.auth.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Bombero {

    private boolean activo;
    private String apellido;
    private String direccion;
    private int dni;
    private String email;
    private LocalDateTime fechaNacimiento;
    private String nombre;
    private String telefono;

    private Usuario usuario;
    private Rol rol;
    private List<Disponibilidad> disponibilidades;
    private List<Asistencia> asistencias;

    public Bombero() {

    }

    public Bombero(boolean activo, String apellido, String direccion, int dni, String email, LocalDateTime fechaNacimiento,
                   String nombre, String telefono, Usuario usuario, Rol rol, List<Disponibilidad> disponibilidades,
                   List<Asistencia> asistencias) {
        this.activo = activo;
        this.apellido = apellido;
        this.direccion = direccion;
        this.dni = dni;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.usuario = usuario;
        this.rol = rol;
        this.disponibilidades = disponibilidades;
        this.asistencias = asistencias;
    }

    public int obtenerAsistenciasEfectivas(List<Convocatoria> convocatorias) {
        int contador = 0;
        for (Convocatoria convocatoria : convocatorias) {
            for (Asistencia asistencia : asistencias) {
                if (asistencia.esDeFechaYGuardiaEnCurso(convocatoria.getFechaHora()))
                    contador++;
            }
        }
        return contador;
    }

    public List<Convocatoria> obtenerConvocatoriasConfirmadas(List<Convocatoria> convocatorias, LocalDate fechaDesde, LocalDate fechaHasta) {
        List<Convocatoria> convocatoriasConfirmadas = new ArrayList<>();
        for (Convocatoria convocatoria : convocatorias) {
            if (convocatoria.estaConfirmada()
                    && convocatoria.estaEnPeriodo(fechaDesde.atStartOfDay(), fechaHasta.atTime(LocalTime.MAX))) {
                convocatoriasConfirmadas.add(convocatoria);
            }
        }
        return convocatoriasConfirmadas;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Disponibilidad> getDisponibilidades() {
        return disponibilidades;
    }

    public void setDisponibilidades(List<Disponibilidad> disponibilidades) {
        this.disponibilidades = disponibilidades;
    }

    public List<Asistencia> getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(List<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }

    @Override
    public String toString() {
        return "BomberoEntity{" +
                "activo=" + activo +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", dni=" + dni +
                ", email='" + email + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", usuario=" + usuario +
                ", rol=" + rol +
                ", disponibilidades=" + disponibilidades +
                ", asistencias=" + asistencias +
                '}';
    }
}//end BomberoEntity