package com.herprogramacion.propiedades.Datos;

/**
 * Created by lds on 26/10/2016.
 */
public class Proper {

    private String id;
    private String nombre;
    private String telefono;
    private String profecion;

    public Proper(String id, String nombre,String telefono,String profecion){
        this.id=id;
        this.nombre=nombre;
        this.telefono=telefono;
        this.profecion=profecion;
    }

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

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

    public String getProfecion() {
        return profecion;
    }

    public void setProfecion(String profecion) {
        this.profecion = profecion;
    }

}

