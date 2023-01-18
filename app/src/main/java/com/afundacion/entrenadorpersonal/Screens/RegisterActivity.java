package com.afundacion.entrenadorpersonal.Screens;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.afundacion.entrenadorpersonal.R;

public class RegisterActivity extends AppCompatActivity {
    private Context context = this;
    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextConfirmarPassword;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

                if (TextUtils.isEmpty(username)){
                    editTextName.setError("Se requiere nombre de usuario");
                    return;
                }

                if (email.isEmpty()){
                    editTextEmail.setError("Se requiere un email");
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    editTextPassword.setError("Se requiere una contraseña");
                    return;
                }

                if (TextUtils.isEmpty(confirmPassword)){
                    editTextConfirmarPassword.setError("Es necesario confirmar la contraseña");
                    return;
                }
                else if(!editTextPassword.equals(editTextConfirmarPassword)){
                    editTextConfirmarPassword.setError("Las contraseñas no coinciden");
                    return;
                }
                Intent myIntent = new Intent(context, LoginActivity.class);
                context.startActivity(myIntent);
            }
        });
    }

}
