package com.xocolatltec.tesji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VerRegistros extends AppCompatActivity {
    //se pone la URL de heroku
    private final String baseUrl="https://registro-nuevos-alumnos-tesji.herokuapp.com/tesji/registronuevosalumnos/alumnos/";
    Button btnatras;
    Intent intent;

    RecyclerView RVAlumnos;
    List<Alumno> listaAlumnos=new ArrayList<>();
    AlumnoAdapter adapter;
    AlumnosInterface alumnoService;
    Button btnadd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_registros);

        //btnatras=findViewById(R.id.btn);

        RVAlumnos=findViewById(R.id.recyclerid);

        btnatras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),RegAlumnosMain.class);
                startActivity(intent);
            }
        });

        Retrofit retrofit=new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LinearLayoutManager llm=new LinearLayoutManager(getApplicationContext());
        RVAlumnos.setLayoutManager(llm);
        adapter =new AlumnoAdapter(listaAlumnos);
        RVAlumnos.setAdapter(adapter);
        DividerItemDecoration itemDecoration =new DividerItemDecoration(RVAlumnos.getContext(),llm.getOrientation());
        RVAlumnos.addItemDecoration(itemDecoration);
        alumnoService = retrofit.create(AlumnosInterface.class);
        Call<List<Alumno>> lista= alumnoService.getAlumno();
        lista.enqueue(new Callback<List<Alumno>>() {
            @Override
            public void onResponse(Call<List<Alumno>> call, Response<List<Alumno>> response) {
                if (response.isSuccessful()) {
                    listaAlumnos = response.body();
                    adapter =new AlumnoAdapter(listaAlumnos);
                    RVAlumnos.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }else{
                    Toast.makeText(getApplicationContext(),"NO HAY ELEMENTOS DISPONIBLES",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Alumno>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"NO HAY RESPUESTA",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
