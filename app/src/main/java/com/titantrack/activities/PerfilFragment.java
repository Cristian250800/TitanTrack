package com.titantrack.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.titantrack.R;

public class PerfilFragment extends Fragment {

    private SessionManager sessionManager;
    private Button btnLogout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        //Este paso lo hemos hecho para hacer un boton de cerrar sesión para poder seguir haciendo las evidencias
        //de la semana 5
        // 1. Inicializamos el SessionManager usando el contexto del Fragmento
        sessionManager = new SessionManager(requireContext());

        // 2. Vinculamos el botón de cerrar sesión
        btnLogout = view.findViewById(R.id.boton_logout);

        if (btnLogout != null) {
            btnLogout.setOnClickListener(v -> {
                // Borramos la sesión guardada
                sessionManager.logoutUser();

                // Redirigimos al LoginActivity y cerramos la actividad principal
                Intent intent = new Intent(requireActivity(), LoginActivity.class);
                startActivity(intent);
                requireActivity().finish();
            });
        }

        return view;
    }
}