package com.xocolatltec.tesji;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        Home_Inicio.OnFragmentInteractionListener,
        Home.OnFragmentInteractionListener,
        OfertaAcademica.OnFragmentInteractionListener,
        Instalaciones.OnFragmentInteractionListener,
        Servicios.OnFragmentInteractionListener,
        Contacto.OnFragmentInteractionListener,
        Ubicacion.OnFragmentInteractionListener,
        RegAlumnosMain.OnFragmentInteractionListener,
        Facebook.OnFragmentInteractionListener,
        Youtube.OnFragmentInteractionListener,
        Desarrollador.OnFragmentInteractionListener {

    Fragment fragmentsNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //se referencia el fragment qeu queremos para nicio
        fragmentsNavigator=new Home();
        getSupportFragmentManager().beginTransaction().replace(R.id.actividad_principal,fragmentsNavigator).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if (id==R.id.action_close){
            dialogConfirmar();
        }

        return super.onOptionsItemSelected(item);
    }
    public void dialogConfirmar(){
        AlertDialog.Builder dialogosalir= new AlertDialog.Builder(this);
        dialogosalir.setTitle("Salir");
        dialogosalir.setMessage("Seguro que decea salir de la aplicacion?");
        dialogosalir.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        dialogosalir.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        dialogosalir.show();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        boolean selectsfragment=false;

        if (id == R.id.nav_home) {
            fragmentsNavigator=new Home();
            selectsfragment=true;
        } else if (id == R.id.nav_carreras) {
            fragmentsNavigator=new OfertaAcademica();
            selectsfragment=true;

        } else if (id == R.id.nav_instalaciones) {
            fragmentsNavigator=new Instalaciones();
            selectsfragment=true;
        } else if (id == R.id.nav_servicios) {
            fragmentsNavigator=new Servicios();
            selectsfragment=true;

        } else if (id == R.id.nav_ubicacion) {
            Uri uri = Uri.parse("https://www.google.com/maps/place/Tecnol%C3%B3gico+de+Estudios+Superiores+de+Jilotepec/@19.916306,-99.581033,15z/data=!4m5!3m4!1s0x0:0x7d5b3039aa655255!8m2!3d19.916306!4d-99.581033");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        } else if (id == R.id.nav_contacto) {
            fragmentsNavigator=new Contacto();
            selectsfragment=true;
        }else if (id == R.id.nav_podcast) {
            fragmentsNavigator=new RegAlumnosMain();
            selectsfragment=true;
        }else if (id == R.id.nav_facebook) {
            fragmentsNavigator=new Ubicacion();
            selectsfragment=true;
        }else if (id == R.id.nav_youtube) {
            Uri uri = Uri.parse("https://www.youtube.com/watch?v=zu4-eIt6Ugc");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }else if (id == R.id.nav_developer) {
            fragmentsNavigator=new Desarrollador();
            selectsfragment=true;

        }
        if (selectsfragment){
            getSupportFragmentManager().beginTransaction().replace(R.id.actividad_principal,fragmentsNavigator).commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
