package com.herprogramacion.propiedades.Datos;

/**
 * Created by lds on 26/10/2016.
 */
public class Config {

    public static final String URL_GET_ALL = "http://192.168.51.18/Android/getPropietario.php";
    public static final String URL_GET_CAS = "http://192.168.51.18/Android/getCasa.php?id=";

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "idPropietario";
    public static final String TAG_NAME = "nombre";
    public static final String TAG_TEL = "telefono";
    public static final String TAG_PRO = "profesion";

    public static final String CAS_ID = "idCasa";
    public static final String CAS_NAME = "nombre";
    public static final String CAS_TAM = "Tamaño";
    public static final String CAS_PRE = "precio";


}
