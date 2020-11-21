package com.xocolatltec.tesji;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Alumno {
    //se declaran los elemnots como en la API y se crean sus GETTERS y SETTERS
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("apellidosPaterno")
    @Expose
    private String apellidosPaterno;
    @SerializedName("apellidoMaterno")
    @Expose
    private String apellidoMaterno;
    @SerializedName("edad")
    @Expose
    private String edad;
    @SerializedName("telefono")
    @Expose
    private String telefono;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("plantelporc")
    @Expose
    private String plantelporc;
    @SerializedName("carrera")
    @Expose
    private String carrera;
    @SerializedName("semestre")
    @Expose
    private int semestre;
    @SerializedName("carreradeainteres")
    @Expose
    private String carreradeainteres;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidosPaterno() {
        return apellidosPaterno;
    }

    public void setApellidosPaterno(String apellidosPaterno) {
        this.apellidosPaterno = apellidosPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPlantelporc() {
        return plantelporc;
    }

    public void setPlantelporc(String plantelporc) {
        this.plantelporc = plantelporc;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getCarreradeainteres() {
        return carreradeainteres;
    }

    public void setCarreradeainteres(String carreradeainteres) {
        this.carreradeainteres = carreradeainteres;
    }
}
