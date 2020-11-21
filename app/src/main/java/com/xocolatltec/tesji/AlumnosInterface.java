package com.xocolatltec.tesji;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
//Aqui se pone el CRUD de la API
public interface AlumnosInterface {
    @GET("alumnos")
    Call<List<Alumno>> getAlumno();

    @POST("alumnos")
    Call<Alumno> registrarAlumnos(@Body Alumno alumno);

    @PUT("alumnos/{index}")
    Call<Alumno> actualizarAlumnos(@Path("index") int index, @Body Alumno alumno);

    @DELETE("alumnos/{index}")
    Call<Alumno> eliminarAlumno(@Path("index") int index);
}
