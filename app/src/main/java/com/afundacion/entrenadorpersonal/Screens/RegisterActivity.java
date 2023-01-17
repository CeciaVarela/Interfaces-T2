package com.afundacion.entrenadorpersonal.Screens;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.afundacion.entrenadorpersonal.R;

public class RegisterActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextConfirmarPassword;
    private Button buttonRegister;

    @Override
    protected void OnCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_register);
        editTextName = findViewById(R.id.user_name);
        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        editTextConfirmarPassword = findViewById(R.id.correct_password);
        buttonRegister = findViewById(R.id.crearCuenta);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editTextName.getText().toString().trim();
                String email = editTextName.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String confirmPassword = editTextConfirmarPassword.getText().toString().trim();
            }
        });
    }
}
