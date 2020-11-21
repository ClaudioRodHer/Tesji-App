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

public class NuevosAlumnos extends AppCompatActivity implements AlumnosInterface {
    Button btnEnviar, btnLimpiar;
    Intent intent;
    private final String baseUrl="https://registro-nuevos-alumnos-tesji.herokuapp.com/tesji/registronuevosalumnos/";

    EditText nom,ape1,ape2,edad,tel,email,planproc,carrera,semestre,carreraint;
    AlumnosInterface alumnosInterface;
    Alumno alumno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevos_alumnos);


        btnEnviar=findViewById(R.id.btnAgregar);
        btnLimpiar=findViewById(R.id.btnlimpiar);
        nom=findViewById(R.id.nom);
        ape1=findViewById(R.id.ap1);
        ape2=findViewById(R.id.ap2);
        edad=findViewById(R.id.edad1);
        tel=findViewById(R.id.tfono);
        email=findViewById(R.id.mail);
        planproc=findViewById(R.id.planp);
        carrera=findViewById(R.id.carrcursa);
        semestre=findViewById(R.id.semc);
        carreraint=findViewById(R.id.cari);

        Retrofit retrofit=new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        alumnosInterface = retrofit.create(AlumnosInterface.class);


        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nom.getText().toString().trim().length() == 0) {
                    nom.setError("Ingrese el nombre");
                    nom.requestFocus();
                } else if (ape1.getText().toString().trim().length() == 0) {
                    ape1.setError("Ingrese sus apellidos");
                    ape1.requestFocus();
                } else if(ape2.getText().toString().trim().length() == 0) {
                    ape2.setError("Ingrese su carrera");
                    ape2.requestFocus();
                } else if(edad.getText().toString().trim().length() == 0) {
                    edad.setError("Ingrese la escuela de procedencia");
                    edad.requestFocus();
                }else if (tel.getText().toString().trim().length() == 0) {
                    tel.setError("Ingrese su correo eléctronico");
                    tel.requestFocus();
                }else if (email.getText().toString().trim().length() == 0) {
                    email.setError("Ingrese su teléfono");
                    email.requestFocus();
                }else if (planproc.getText().toString().trim().length() == 0) {
                    planproc.setError("Ingrese su plantel deproc");
                    planproc.requestFocus();
                }else if (carrera.getText().toString().trim().length() == 0) {
                    carrera.setError("Ingrese su ingrsa tu carrera ctual");
                    planproc.requestFocus();
                }else if (semestre.getText().toString().trim().length() == 0) {
                    semestre.setError("Ingrese su ingresa tu email");
                    semestre.requestFocus();
                }else if (carreraint.getText().toString().trim().length() == 0) {
                    carreraint.setError("Ingrese su carrera de interes");
                    carreraint.requestFocus();
                }else{
                    alumno = new Alumno();
                    alumno.setNombre(nom.getText().toString());
                    alumno.setApellidosPaterno(ape1.getText().toString());
                    alumno.setApellidoMaterno(ape2.getText().toString());

                    alumno.setEdad(edad.getText().toString());
                    alumno.setTelefono(tel.getText().toString());
                    alumno.setEmail(email.getText().toString());
                    alumno.setPlantelporc(planproc.getText().toString());
                    alumno.setCarrera(carrera.getText().toString());
                    alumno.setSemestre(Integer.parseInt(semestre.getText().toString()));
                    alumno.setCarreradeainteres(carreraint.getText().toString());
                    registrarAlumnos(alumno);

                }

            }
        });
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nom.setText("");
                ape1.setText("");
                ape2.setText("");
                edad.setText("");
                tel.setText("");
                email.setText("");
                planproc.setText("");
                carrera.setText("");
                semestre.setText("");
                carreraint.setText("");

            }
        });
    }

    @Override
    public Call<List<Alumno>> getAlumno() {
        return null;
    }

    @Override
    public Call<Alumno> registrarAlumnos(Alumno alumno) {
        Call<Alumno> p = alumnosInterface.registrarAlumnos(alumno);
        p.enqueue(new Callback<Alumno>(){
            @Override
            public void onResponse(Call<Alumno> call, Response<Alumno> response) {
                if(response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "INSERTADO EXITOSAMENTE", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Alumno> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"NO HAY RESPUESTA",Toast.LENGTH_SHORT).show();
            }


        });

        return null;
    }

    @Override
    public Call<Alumno> actualizarAlumnos(int index, Alumno alumno) {
        return null;
    }

    @Override
    public Call<Alumno> eliminarAlumno(int index) {
        return null;
    }
}
