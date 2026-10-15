package com.titantrack.activities;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.titantrack.R;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // 1. Vinculación de vistas
        etEmail = findViewById(R.id.correo_registro);
        etPassword = findViewById(R.id.contrasena_registro);
        btnRegister = findViewById(R.id.boton_registro);

        // 2. Interceptamos el clic en el botón de registro
        if (btnRegister != null) {
            btnRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    validarRegistro();
                }
            });
        }
    }

    // Mismo método que implementa la Fase 1 para el Registro
    private void validarRegistro() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        boolean esValido = true;

        // Validación del Correo
        if (email.isEmpty()) {
            etEmail.setError("El correo es obligatorio");
            esValido = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Introduce un correo válido");
            esValido = false;
        }

        // Validación de la Contraseña
        if (password.isEmpty()) {
            etPassword.setError("La contraseña es obligatoria");
            esValido = false;
        } else if (password.length() < 8) {
            etPassword.setError("La contraseña debe tener al menos 8 caracteres");
            esValido = false;
        }

        // 3. Si no hay errores lo registramos
        if (esValido) {
            Toast.makeText(this, "Registro completado con éxito", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}