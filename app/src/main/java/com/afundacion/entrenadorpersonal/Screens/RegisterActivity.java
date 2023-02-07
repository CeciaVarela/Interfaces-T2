package com.afundacion.entrenadorpersonal.Screens;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.afundacion.entrenadorpersonal.Drawer.MainActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import com.afundacion.entrenadorpersonal.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {
    private Context context = this;
    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextConfirmarPassword;
    private Button buttonRegister;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editTextName = findViewById(R.id.user_name);
        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        editTextConfirmarPassword = findViewById(R.id.correct_password);
        buttonRegister = findViewById(R.id.crearCuenta);

        queue = Volley.newRequestQueue(this);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editTextName.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
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
                else if(!password.equals(confirmPassword)){
                    editTextConfirmarPassword.setError("Las contraseñas no coinciden");
                    return;
                }
                Intent myIntent = new Intent(context, LoginActivity.class);
                context.startActivity(myIntent);
                sendPostRequest();
            }
        });
    }

    private void sendPostRequest(){
        JSONArray requestBody = new JSONArray();
        try{
            requestBody.put(Integer.parseInt("name"), editTextName.getText().toString());
            requestBody.put("email", editTextEmail.getText().toString());
            requestBody.put("password", editTextPassword.getText().toString());
            requestBody.put("confirmdpassword", editTextConfirmarPassword.getText().toString());
        }catch (JSONException e) {
            throw new RuntimeException(e);
        }
        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.POST,
                "https://63be86bc585bedcb36af7637.mockapi.io/Users",
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if (editTextEmail.length() == 0) {
                            Toast.makeText(context, "Cuenta registrada con éxito", Toast.LENGTH_LONG).show();
                         }
                        Toast.makeText(context, "El email ya está registrado", Toast.LENGTH_LONG).show();
                        finish();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (error.networkResponse == null){
                            Toast.makeText(context, "No se pudo establecer la conexión", Toast.LENGTH_LONG).show();
                        } else {
                            int serverCode = error.networkResponse.statusCode;
                            Toast.makeText(context, "El servidor respondió con: " + serverCode, Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
        this.queue.add(request);
    }

}
