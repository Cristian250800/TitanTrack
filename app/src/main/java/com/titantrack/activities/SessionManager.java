package com.titantrack.activities;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    private static final String PREF_NAME = "TitanTrackSession";
    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";
    private static final String KEY_EMAIL = "userEmail";
    private static final String KEY_UNIT_SYSTEM = "unitSystem";

    private final SharedPreferences pref;
    private final SharedPreferences.Editor editor;

    public SessionManager(Context context) {
        pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    // Guardar sesión tras login exitoso
    public void createLoginSession(String email) {
        editor.putBoolean(KEY_IS_LOGGED_IN, true);
        editor.putString(KEY_EMAIL, email);
        editor.apply();
    }

    // Verificar si el usuario ya está autentificado
    public boolean isLoggedIn() {
        return pref.getBoolean(KEY_IS_LOGGED_IN, false);
    }

    // Obtener el email guardado
    public String getUserEmail() {
        return pref.getString(KEY_EMAIL, "");
    }

    // Guardar preferencia de unidades
    public void setUnitSystem(String unitSystem) {
        editor.putString(KEY_UNIT_SYSTEM, unitSystem);
        editor.apply();
    }

    // Leer preferencia de unidades (usamos métrico por defecto)
    public String getUnitSystem() {
        return pref.getString(KEY_UNIT_SYSTEM, "metrico");
    }

    // Cerrar sesión
    public void logoutUser() {
        editor.clear();
        editor.apply();
    }
}