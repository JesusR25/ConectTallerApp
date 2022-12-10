package com.example.mrfixfinal.Objetos;

import java.io.Serializable;

public class Producto implements Serializable {
    private String IDProducto,NombreProducto,MarcaProducto,DescripcionProducto,PrecioProducto,ExistenciaProducto;

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        NombreProducto = nombreProducto;
    }

    public String getMarcaProducto() {
        return MarcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        MarcaProducto = marcaProducto;
    }

    public String getDescripcionProducto() {
        return DescripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        DescripcionProducto = descripcionProducto;
    }

    public String getPrecioProducto() {
        return PrecioProducto;
    }

    public void setPrecioProducto(String precioProducto) {
        PrecioProducto = precioProducto;
    }

    public String getExistenciaProducto() {
        return ExistenciaProducto;
    }

    public void setExistenciaProducto(String existenciaProducto) {
        ExistenciaProducto = existenciaProducto;
    }

    public String getIDProducto() {
        return IDProducto;
    }

    public void setIDProducto(String IDProducto) {
        this.IDProducto = IDProducto;
    }
}
