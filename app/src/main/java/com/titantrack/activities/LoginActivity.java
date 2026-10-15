package com.titantrack.activities;


import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.titantrack.R;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    private Button btnLogin;
    private TextView tvRegister;
    private TextView tvRecover;

    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1. Inicializamos el SessionManager
        sessionManager = new SessionManager(this);

        // 2.Si el usuario ya está autenticado, vamos directo al Dashboard
        if (sessionManager.isLoggedIn()) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.correo_login);
        etPassword = findViewById(R.id.contrasena_login);

        btnLogin = findViewById(R.id.boton_login);
        tvRegister = findViewById(R.id.ir_a_registro);
        tvRecover = findViewById(R.id.olvidaste_contrasena);

        // 3. Navegación a MainActivity (Dashboard)
        if (btnLogin != null) {
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    validarYAcceder();
                }
            });
        }

        // 4. Navegación a RegisterActivity
        if (tvRegister != null) {
            tvRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                    startActivity(intent);
                }
            });
        }

        // 5. Navegación a RecoverActivity
        if (tvRecover != null) {
            tvRecover.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(LoginActivity.this, RecoverActivity.class);
                    startActivity(intent);
                }
            });
        }
    }

    //Método para Sanitización y Feedback visual
    private void validarYAcceder(){String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        boolean esValido = true;

        // Validación del correo
        if (email.isEmpty()) {
            etEmail.setError("El correo es obligatorio");
            esValido = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Introduce un correo válido");
            esValido = false;
        }

        // Validación de la contraseña

        if (password.isEmpty()) {
            etPassword.setError("La contraseña es obligatoria");
            esValido = false;
        } else if (password.length() < 8) {
            etPassword.setError("La contraseña debe tener al menos 8 caracteres");
            esValido = false;
        }

        // 5. Aqui solo navegamos si no nos saltan errores
        if (esValido) {
            //Guarda la sesión en persistencia local
            sessionManager.createLoginSession(email);
            //Redirige al Dashboard
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}