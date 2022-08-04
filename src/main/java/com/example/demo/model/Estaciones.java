package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
//@Document(collection="estaciones")
public class Estaciones implements Serializable {

    private static final long serialVersionUID = 1L;


    public static String ID_ESTACION_SANLUIS = "id_estacion";
    public static String NOMBRE = "nombre";
    public static String LATITUD = "latitud";
    public static String LONGITUD = "longitud";
    public static String ALTURA = "altura";
    public static String CREPUSCULO_MATUTINO = "CrepusculoMatutino";
    public static String CREPUSCULO_VESPERTINO = "CrepusculoVespertino";
    public static String ESTADO = "estado";
    public static String SISTEMA = "sistema";

    public static String ALTURA_INTA = "alt";

    public static String DESC = "desc";

    public static String ID_ESTACION = "id";

    public static String CODE = "code";

    public static String NOMBRE_REDES = "title";

    public static String LOCALIDAD_REDES= "citie";

    public static String ULTIMA_INFORMACION= "last_date";

    public static String LATITUD_OMIXON="latitude";

    public static String LONGITUD_OMIXON= "longitude";




    public static String ID_C = "idC";

    public static String ID_T = "idT";

    public static String LATITUD_INTA = "lat";

    public static String LONGITUD_INTA = "lng";

    public static String LOCALIDAD_INTA = "loc";

    public static String NOMBRE_INTA = "nom";

    public static String PROVINCIA_INTA = "prov";

    public static String TIPO_INTA = "tip";

    public static String UBICACION_INTA = "ubic";


    private Long idPropietario;
    private Long id;

    private Long code;
    private String nombre;
    private String latitud;
    private String longitud;
    private String altura;
    private String CrepusculoMatutino;
    private String CrepusculoVespertino;
    private boolean estado;
    private String sistema;

    private String ubicacion;

    private String tipo;

    private String provincia;

    private String localidad;

    private String descripcion;

    private Float alturaInta;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }



    public Float getAlturaInta() {
        return alturaInta;
    }

    public void setAlturaInta(Float alturaInta) {
        this.alturaInta = alturaInta;
    }



    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }




    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }



    public Long getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(Long idPropietario) {
        this.idPropietario = idPropietario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getCrepusculoMatutino() {
        return CrepusculoMatutino;
    }

    public void setCrepusculoMatutino(String crepusculoMatutino) {
        CrepusculoMatutino = crepusculoMatutino;
    }

    public String getCrepusculoVespertino() {
        return CrepusculoVespertino;
    }

    public void setCrepusculoVespertino(String crepusculoVespertino) {
        CrepusculoVespertino = crepusculoVespertino;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getSistema() {
        return sistema;
    }



    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    @Override
    public String toString() {
        return "Estaciones [idPropietario="
                +getIdPropietario()
                + ", id=" + getId()
                + ", nombre='" + getNombre() + '\''
                + ", localidad='" + getLocalidad() + '\''
                + ", latitud='" + getLatitud() + '\''
                + ", longitud='" + getLongitud() + '\''
                + ", altura='" + getAltura() + '\''
                + ", CrepusculoMatutino='" + getCrepusculoMatutino() + '\''
                + ", CrepusculoVespertino='" + getCrepusculoVespertino() + '\''
                + ", estado=" + isEstado()
                + ", sistema='" + getSistema()
                + '\'' +
                ']';
    }


}
