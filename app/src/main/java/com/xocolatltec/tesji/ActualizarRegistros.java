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

public class ActualizarRegistros extends AppCompatActivity implements AlumnosInterface{
    Button btnEnviar2, btnLimpiar2;
    Intent intent;
    private final String baseUrl="https://registro-nuevos-alumnos-tesji.herokuapp.com/tesji/registronuevosalumnos/";

    EditText nom2,ape12,ape22,edad2,tel2,email2,planproc2,carrera2,semestre2,carreraint2,ind;
    AlumnosInterface alumnosInterface;
    Alumno alumno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_registros);

        btnEnviar2=findViewById(R.id.btnAgregar2);
        btnLimpiar2=findViewById(R.id.btnlimpiar2);
        ind=findViewById(R.id.indets);
        nom2=findViewById(R.id.nom2);
        ape12=findViewById(R.id.ap12);
        ape22=findViewById(R.id.ap22);
        edad2=findViewById(R.id.edad12);
        tel2=findViewById(R.id.tfono2);
        email2=findViewById(R.id.mail2);
        planproc2=findViewById(R.id.planp2);
        carrera2=findViewById(R.id.carrcursa2);
        semestre2=findViewById(R.id.semc2);
        carreraint2=findViewById(R.id.cari2);

        Retrofit retrofit=new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        alumnosInterface = retrofit.create(AlumnosInterface.class);



        btnEnviar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nom2.getText().toString().trim().length() == 0) {
                    nom2.setError("Ingrese el nombre");
                    nom2.requestFocus();
                } else if (ape12.getText().toString().trim().length() == 0) {
                    ape12.setError("Ingrese sus apellidos");
                    ape12.requestFocus();
                } else if(ape22.getText().toString().trim().length() == 0) {
                    ape22.setError("Ingrese su carrera");
                    ape22.requestFocus();
                } else if(edad2.getText().toString().trim().length() == 0) {
                    edad2.setError("Ingrese la escuela de procedencia");
                    edad2.requestFocus();
                }else if (tel2.getText().toString().trim().length() == 0) {
                    tel2.setError("Ingrese su correo eléctronico");
                    tel2.requestFocus();
                }else if (email2.getText().toString().trim().length() == 0) {
                    email2.setError("Ingrese su teléfono");
                    email2.requestFocus();
                }else if (planproc2.getText().toString().trim().length() == 0) {
                    planproc2.setError("Ingrese su plantel deproc");
                    planproc2.requestFocus();
                }else if (carrera2.getText().toString().trim().length() == 0) {
                    carrera2.setError("Ingrese su ingrsa tu carrera ctual");
                    planproc2.requestFocus();
                }else if (semestre2.getText().toString().trim().length() == 0) {
                    semestre2.setError("Ingrese su ingresa tu email");
                    semestre2.requestFocus();
                }else if (carreraint2.getText().toString().trim().length() == 0) {
                    carreraint2.setError("Ingrese su carrera de interes");
                    carreraint2.requestFocus();
                }else if(ind.getText().toString().trim().length()==0){
                    ind.setError("Ingrese el índice a actualizar");
                    ind.requestFocus();
                }else{
                    final int index=Integer.parseInt(ind.getText().toString());
                    if(index<0 || index>1000) {
                        ind.setError("Ingrese indice valido");
                        ind.requestFocus();
                    }else {
                        alumno = new Alumno();
                        alumno.setNombre(nom2.getText().toString());
                        alumno.setApellidosPaterno(ape12.getText().toString());
                        alumno.setApellidoMaterno(ape22.getText().toString());

                        alumno.setEdad(edad2.getText().toString());
                        alumno.setTelefono(tel2.getText().toString());
                        alumno.setEmail(email2.getText().toString());
                        alumno.setPlantelporc(planproc2.getText().toString());
                        alumno.setCarrera(carrera2.getText().toString());
                        alumno.setSemestre(Integer.parseInt(semestre2.getText().toString()));
                        alumno.setCarreradeainteres(carreraint2.getText().toString());
                        actualizarAlumnos(index, alumno);
                    }
                }

            }
        });
        btnLimpiar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ind.setText("");
                nom2.setText("");
                ape12.setText("");
                ape22.setText("");
                edad2.setText("");
                tel2.setText("");
                email2.setText("");
                planproc2.setText("");
                carrera2.setText("");
                semestre2.setText("");
                carreraint2.setText("");
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
        Call<Alumno> p = alumnosInterface.actualizarAlumnos(index,alumno);
        p.enqueue(new Callback<Alumno>() {
            @Override
            public void onResponse(Call<Alumno> call, Response<Alumno> response) {
                if(response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "EL ALUMNO SE HA ACTUALIZADO EXITOSAMENTE", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "INDICE ALUMNO  IN-EXISTE", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Alumno> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "NO HAY RESPUESTA",Toast.LENGTH_SHORT).show();
            }
        });
        return null;
    }

    @Override
    public Call<Alumno> eliminarAlumno(int index) {
        return null;
    }
}