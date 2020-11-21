package com.xocolatltec.tesji;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import fr.ganfra.materialspinner.MaterialSpinner;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OfertaAcademica.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OfertaAcademica#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OfertaAcademica extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    View view;
    MaterialSpinner oferta;
    Button ver;
    Button masINf;
    ImageView imgcarrera;
    TextView infCarrera;

    String [] carreras={
            "Ingeniería Industrial",
            "Ingeniería en Informática en Liquidación",
            "Ingeniería en Sistemas Computacionales",
            "Ingeniería Mecatrónica",
            "Ingeniería Civil",
            "Licenciatura en Administración",
            "Ingeniería Química,",
            "Ingeniería en Logística",
            "Ingeniería Eléctrica",
            "Ingeniería en Tecnologías de la Información y Comunicaciones"};
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public OfertaAcademica() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OfertaAcademica.
     */
    // TODO: Rename and change types and number of parameters
    public static OfertaAcademica newInstance(String param1, String param2) {
        OfertaAcademica fragment = new OfertaAcademica();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_oferta_academica, container, false);
        // Inflate the layout for this fragment
        oferta=view.findViewById(R.id.mtSpinnerOpfAcad);
        ver=view.findViewById(R.id.btnVER);
        masINf=view.findViewById(R.id.masInfBTN);
        imgcarrera=view.findViewById(R.id.imgViewerCarrera);
        infCarrera=view.findViewById(R.id.txtInfCarrera);

        //ArrayAdapter<String> adapterOAC=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,carreras);
        ArrayAdapter adapterOAC=new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,carreras);
       oferta.setAdapter(adapterOAC);

        ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (oferta.getSelectedItemPosition()==0){
                    oferta.setError("Selecciona un a carrera para visualizar");
                }else if (oferta.getSelectedItemPosition()==1){
                    imgcarrera.setImageResource(R.drawable.ind);
                    infCarrera.setText("La ingenieria Industrial \n" +
                            "Esta busca formar profecionistas que sean líderes, creativos y " +
                            "emprendedores con visión sistemática, capacidad analítica y competitiva \n" +
                            "Quieres saber mas?... Da CLICK en el boton ");
                }else if (oferta.getSelectedItemPosition()==2){
                    imgcarrera.setImageResource(R.drawable.inf);
                    infCarrera.setText("La ingenieria Informatica \n" +
                            "EEl ingeniero en Informática podrá laborar en cualquier ámbito " +
                            "que requiera soluciones a problemas que integren hardware y software \n" +
                            "Quieres saber mas?... Da CLICK en el boton ");
                }else if (oferta.getSelectedItemPosition()==3){
                    imgcarrera.setImageResource(R.drawable.isic);
                    infCarrera.setText("La ingenieria En Sistemas Computacionales \n" +
                                "Esta busca Capaces de diseñar, implementar y administrar" +
                            " bases de datos y servidores para aportar soluciones" +
                            " innovadoras en beneficio de la sociedad.\n" +
                            "Quieres saber mas?... Da CLICK en el boton ");
                }else if (oferta.getSelectedItemPosition()==4){
                    imgcarrera.setImageResource(R.drawable.meca);
                    infCarrera.setText("La ingenieria Mecatronica \n" +
                            "   El egresado de Ingeniería Mecatrónica puede " +
                            "desarrollarse como empresario, dueño y/o asociado en " +
                            "empresas públicas, privadas, transnacionales y PYMES; \n" +
                            "Quieres saber mas?... Da CLICK en el boton ");
                }else if (oferta.getSelectedItemPosition()==5){
                    imgcarrera.setImageResource(R.drawable.civ);
                    infCarrera.setText("La ingenieria Civil \n" +
                            "El campo laboral del Ingeniero Civil es versátil" +
                            " en el sentido de que puede proyectar," +
                            " diseñar y construir obras civiles \n" +
                            "Quieres saber mas?... Da CLICK en el boton ");
                }else if (oferta.getSelectedItemPosition()==6){
                    imgcarrera.setImageResource(R.drawable.admin);
                    infCarrera.setText("Lic. En Administracion \n" +
                            "El Licenciado en Administración podrá ser empresario  " +
                            ", laborar en una empresa,ocupar puestos(etc..) \n" +
                            "Quieres saber mas?... Da CLICK en el boton ");
                }else if (oferta.getSelectedItemPosition()==7){
                    imgcarrera.setImageResource(R.drawable.quim);
                    infCarrera.setText("La ingenieria Quimica \n" +
                            "El campo de trabajo del Ingeniero Químico  del TES JI    " +
                            "*Industria de Alimento\n" +
                            "*Industria Farmacéutica\n" +
                            "*Energéticos, fuentes alternas de energía\n" +
                            "*Control de contaminación\n" +
                            "*Simulación de procesos " +
                            "etc..\n" +
                            "Quieres saber mas?... Da CLICK en el boton ");
                }else if (oferta.getSelectedItemPosition()==8){
                    imgcarrera.setImageResource(R.drawable.log);
                    infCarrera.setText("La ingenieria Logistica \n" +
                            "El Ingeniero en Logística es un profesional con disciplina de estudio, " +
                            "responsabilidad social y desempeño ético, con capacidades " +
                            "de desarrollo autónomo, de liderazgo, " +
                            "de investigación, competente para diseñar " +
                            "y administrar Sistemas Logísticos \n" +
                            "Quieres saber mas?... Da CLICK en el boton ");
                }else if (oferta.getSelectedItemPosition()==9){
                    imgcarrera.setImageResource(R.drawable.inel);
                    infCarrera.setText("La ingenieria Electrica \n" +
                            "Esta busca formar profecionistas on capacidad creativa, emprendedora," +
                            " de análisis, liderazgo y capacidad de trabajo en equipo," +
                            " que realicen actividades de diseño, innovación, adaptación " +
                            "y transferencia de tecnologías  \n" +
                            "Quieres saber mas?... Da CLICK en el boton ");
                }else if (oferta.getSelectedItemPosition()==10){
                    imgcarrera.setImageResource(R.drawable.tics);
                    infCarrera.setText("La ingenieria TIC'S \n" +
                            "Esta busca Formar profesionistas capaces de integrar y" +
                            " administrar tecnologías de la información y comunicaciones, " +
                            "que contribuyan a la productividad y el logro de los objetivos" +
                            " estratégicos de las organizaciones \n" +
                            "Quieres saber mas?... Da CLICK en el boton ");
                }
            }
        });
        masINf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://tesji.edomex.gob.mx/oferta_academica");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        //http://tesji.edomex.gob.mx/oferta_academica
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
