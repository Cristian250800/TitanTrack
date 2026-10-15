package com.titantrack.activities;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.titantrack.R;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vinculamos la barra de navegación del XML
        bottomNav = findViewById(R.id.bottom_navigation);

        // 1. Cargamos por defecto el primer fragmento
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new RutinasFragment())
                    .commit();
        }

        // 2. Configurar el escuchador para cambiar de pantalla al pulsar los iconos
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                int itemId = item.getItemId();

                // En esta parte identificamos qué botón se ha pulsado según su ID
                if (itemId == R.id.nav_rutinas) {
                    selectedFragment = new RutinasFragment();
                } else if (itemId == R.id.nav_entrenamiento) {
                    selectedFragment = new EntrenamientoFragment();
                } else if (itemId == R.id.nav_perfil) {
                    selectedFragment = new PerfilFragment();
                }

                // Reemplazamos el fragmento actual por el que hemos seleccionado
                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, selectedFragment)
                            .commit();
                    return true;
                }
                return false;
            }
        });
    }
}