package com.xocolatltec.tesji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EliminarRegistros extends AppCompatActivity implements  AlumnosInterface {
    Button btnEnviar, btnLimpiar;
    private final String baseUrl="https://registro-nuevos-alumnos-tesji.herokuapp.com/tesji/registronuevosalumnos/";

    EditText miind;
    AlumnosInterface alumnosInterface;
    Alumno alumno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_registros);


        btnEnviar=findViewById(R.id.btnedlit);

        miind=findViewById(R.id.tveliminarr);

        Retrofit retrofit=new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        alumnosInterface = retrofit.create(AlumnosInterface.class);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(miind.getText().toString().trim().length()==0){
                    miind.setError("Ingrese el indice a eliminar");
                }else{
                    int index=Integer.parseInt(miind.getText().toString());
                    if(index<0 || index>1000) {
                        miind.setError("Ingrese indice valido");
                    }else{
                        eliminarAlumno(index);
                    }
                }
            }
        });
    }

    @Override
    public Call<List<Alumno>> getAlumno() {
        return null;
    }

    @Override
    public Call<Alumno> registrarAlumnos(Alumno alumno) {
        return null;
    }

    @Override
    public Call<Alumno> actualizarAlumnos(int index, Alumno alumno) {
        return null;
    }

    @Override
    public Call<Alumno> eliminarAlumno(int index) {

        Call<Alumno> p=alumnosInterface.eliminarAlumno(index);
        p.enqueue(new Callback<Alumno>() {
            @Override
            public void onResponse(Call<Alumno> call, Response<Alumno> response) {
                if(response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "ALUMNO ELIMINADO EXITOSAMENTE POR JOHN WICK", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "EL INDICE DEL ALUMNO NO EXISTE", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Alumno> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"NO HAY RESPUESTA",Toast.LENGTH_SHORT).show();
            }
        });

        return null;
    }
}
