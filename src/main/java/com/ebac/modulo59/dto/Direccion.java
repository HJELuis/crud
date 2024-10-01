package com.ebac.modulo59.dto;

public class Direccion {
    private int idDireccion;
    private int idUsuario;
    private String calle;
    private int numero;
    private String estado;

    public String getCalle() {
        return calle;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public int getNumero() {
        return numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "idDireccion=" + idDireccion +
                ", idUsuario=" + idUsuario +
                ", calle='" + calle + '\'' +
                ", numero=" + numero +
                ", estado='" + estado + '\'' +
                '}';
    }
}
