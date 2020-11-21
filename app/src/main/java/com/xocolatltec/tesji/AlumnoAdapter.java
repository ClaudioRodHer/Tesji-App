package com.xocolatltec.tesji;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AlumnoAdapter extends RecyclerView.Adapter<AlumnoAdapter.AlumnoViewHolder> {
//se obtienen los datos y se adaptan para su posterior uso

    List<Alumno> lista;
    public AlumnoAdapter(List<Alumno>lista){
        this.lista=lista;
    }
    @Override
    public AlumnoViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.items,parent,false);
        return new AlumnoViewHolder(v);
    }
    @Override
    public void onBindViewHolder(AlumnoViewHolder alumnoViewHolder, int i) {
        alumnoViewHolder.bindAlumno(lista.get(i));
    }
    @Override
    public int getItemCount() {
        return lista.size();
    }
    public class AlumnoViewHolder extends RecyclerView.ViewHolder{
        TextView nombre;
        TextView apellidopaterno;
        TextView apellidomaterno;
        TextView edad;
        TextView telefono;
        TextView email;
        TextView plantelprocedencia;
        TextView carrera;
        TextView semestre;
        TextView carrerainteres;

        public AlumnoViewHolder(View itemView) {
            super(itemView);
            nombre=itemView.findViewById(R.id.nombre);
            apellidopaterno=itemView.findViewById(R.id.apPaterno);
            apellidomaterno=itemView.findViewById(R.id.apMaterno);
            edad=itemView.findViewById(R.id.edadd);
            telefono=itemView.findViewById(R.id.telefo);
            email=itemView.findViewById(R.id.emailll);
            plantelprocedencia=itemView.findViewById(R.id.escProc);
            carrera=itemView.findViewById(R.id.carrera);
            semestre=itemView.findViewById(R.id.semestre);
            carrerainteres=itemView.findViewById(R.id.carInt);
        }

        public void bindAlumno(Alumno alumno){

            nombre.setText(String.valueOf(alumno.getNombre()));
            apellidopaterno.setText(String.valueOf(alumno.getApellidosPaterno()));
            apellidomaterno.setText(String.valueOf(alumno.getApellidoMaterno()));
            edad.setText(String.valueOf(alumno.getEdad()));
            telefono.setText(String.valueOf(alumno.getTelefono()));
            email.setText(String.valueOf(alumno.getEmail()));
            plantelprocedencia.setText(String.valueOf(alumno.getPlantelporc()));
            carrera.setText(String.valueOf(alumno.getCarrera()));
            semestre.setText(String.valueOf(alumno.getSemestre()));
            carrerainteres.setText(String.valueOf(alumno.getCarreradeainteres()));

        }
    }

}
