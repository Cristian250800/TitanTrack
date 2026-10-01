package com.titantrack.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.titantrack.R;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private TextView tvRegister;
    private TextView tvRecover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Vinculación con los IDs de tu XML
        btnLogin = findViewById(R.id.boton_login);
        tvRegister = findViewById(R.id.ir_a_registro);
        tvRecover = findViewById(R.id.olvidaste_contrasena);

        // 1. Navegación a MainActivity (Dashboard)
        if (btnLogin != null) {
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish(); // Cierra LoginActivity para no volver atrás
                }
            });
        }

        // 2. Navegación a RegisterActivity
        if (tvRegister != null) {
            tvRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                    startActivity(intent);
                }
            });
        }

        // 3. Navegación a RecoverActivity
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
}