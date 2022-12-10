package com.example.mrfixfinal.Objetos;

import java.io.Serializable;

public class User implements Serializable {
    private String IDCliente, NombreCliente, ApePatCliente, ApeMatCliente, CorreoCliente, TelefonoCliente, Username, Contrasena;

    public String getIDCliente() {
        return IDCliente;
    }

    public void setIDCliente(String IDCliente) {
        this.IDCliente = IDCliente;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        NombreCliente = nombreCliente;
    }

    public String getApePatCliente() {
        return ApePatCliente;
    }

    public void setApePatCliente(String apePatCliente) {
        ApePatCliente = apePatCliente;
    }

    public String getApeMatCliente() {
        return ApeMatCliente;
    }

    public void setApeMatCliente(String apeMatCliente) {
        ApeMatCliente = apeMatCliente;
    }

    public String getCorreoCliente() {
        return CorreoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        CorreoCliente = correoCliente;
    }

    public String getTelefonoCliente() {
        return TelefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        TelefonoCliente = telefonoCliente;
    }

    public String getUsuario() {
        return Username;
    }

    public void setUsuario(String usuario) {
        Username = usuario;
    }

    public String getContraseña() {
        return Contrasena;
    }

    public void setContraseña(String contrasena) {
        Contrasena = contrasena;
    }
}
