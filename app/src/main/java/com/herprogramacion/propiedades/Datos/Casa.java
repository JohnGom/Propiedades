package com.herprogramacion.propiedades.Datos;

/**
 * Created by lds on 26/10/2016.
 */
public class Casa {


    private String nombre;
    private String tamaño;
    private String precio;

    public Casa(String nombre,String tamaño,String precio){

        this.nombre=nombre;
        this.tamaño=tamaño;
        this.precio=precio;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
