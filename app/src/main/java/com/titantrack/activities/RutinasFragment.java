package com.titantrack.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.titantrack.R;
// Asegúrate de importar tu modelo y adaptador si están en otra carpeta
// import com.titantrack.models.RutinaModel;

import java.util.ArrayList;
import java.util.List;

public class RutinasFragment extends Fragment {

    private RecyclerView rvRutinas;
    private RutinasAdapter adaptador;
    private List listaMockDatos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Inflar la vista (el contenedor principal)
        View view = inflater.inflate(R.layout.fragment_rutinas, container, false);

        // Vincular el RecyclerView de nuestro XML
        rvRutinas = view.findViewById(R.id.rvRutinas);
        rvRutinas.setLayoutManager(new LinearLayoutManager(getContext()));

        // Simulación de Datos
        cargarDatosSimulados();

        //Inicialización  del Adaptador y enganche al RecyclerView
        adaptador = new RutinasAdapter(listaMockDatos);
        rvRutinas.setAdapter(adaptador);

        return view;
    }

    // Mock Data
    private void cargarDatosSimulados() {
        listaMockDatos = new ArrayList<>();
        listaMockDatos.add(new RutinaModel("Fuerza Total: Cuerpo Entero", "Duración: 60 min • Dificultad: Alta"));
        listaMockDatos.add(new RutinaModel("Cardio HIIT Quema Grasa", "Duración: 30 min • Dificultad: Alta"));
        listaMockDatos.add(new RutinaModel("Espalda y Bíceps", "Duración: 45 min • Dificultad: Media"));
        listaMockDatos.add(new RutinaModel("Piernas de Acero", "Duración: 50 min • Dificultad: Alta"));
        listaMockDatos.add(new RutinaModel("Yoga y Estiramientos", "Duración: 20 min • Dificultad: Baja"));
        listaMockDatos.add(new RutinaModel("Pecho y Tríceps (Básico)", "Duración: 40 min • Dificultad: Baja"));
        listaMockDatos.add(new RutinaModel("Core y Abdominales", "Duración: 15 min • Dificultad: Media"));
        listaMockDatos.add(new RutinaModel("Resistencia Funcional", "Duración: 45 min • Dificultad: Media"));
        listaMockDatos.add(new RutinaModel("Tren Superior Explosivo", "Duración: 55 min • Dificultad: Alta"));
        listaMockDatos.add(new RutinaModel("Movilidad Articular", "Duración: 25 min • Dificultad: Baja"));
    }
}