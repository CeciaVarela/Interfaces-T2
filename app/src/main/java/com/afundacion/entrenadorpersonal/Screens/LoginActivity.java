package com.afundacion.entrenadorpersonal.Screens;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.afundacion.entrenadorpersonal.Drawer.MainActivity;
import com.afundacion.entrenadorpersonal.R;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    private Context context = this;
    private RequestQueue requestQueue;
    private Button buttonIniciarSesion;
    private EditText editTextEmailLog;
    private EditText editTextPasswordLog;
    private TextView crearCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextEmailLog = findViewById(R.id.login_email);
        editTextPasswordLog = findViewById(R.id.login_password);
        buttonIniciarSesion = findViewById(R.id.login);
        crearCuenta = findViewById(R.id.registro);

        requestQueue = Volley.newRequestQueue(this);

        buttonIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startUserSession();
            }
        });

        crearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(context, RegisterActivity.class);
                context.startActivity(myIntent);
            }
        });
    }

    public void startUserSession() {
        JSONObject requestBody = new JSONObject();
        try {
            requestBody.put("email", editTextEmailLog.getText().toString());
            requestBody.put("password", editTextPasswordLog.getText().toString());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                "https://63be86bc585bedcb36af7637.mockapi.io/Users?email="+editTextEmailLog,
                requestBody,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String receivedToken="";
                        String email = editTextEmailLog.getText().toString();
                        String password = editTextPasswordLog.getText().toString();
                        try {
                            if (email.equals(response.getString("email")) && password.equals(response.getString("password"))){
                                receivedToken = response.getString("sessionToken");
                                SharedPreferences preferences = getSharedPreferences("SESSIONS_APP_PREFS", MODE_PRIVATE);
                                SharedPreferences.Editor editor = preferences.edit();
                                editor.putString("VALID_EMAIL", editTextEmailLog.getText().toString());
                                editor.putString("VALID_TOKEN", receivedToken);
                                editor.commit();
                                finish();
                            }
                            Toast.makeText(context, "Contraseña incorrecta: ", Toast.LENGTH_SHORT).show();
                        }catch(JSONException e){
                            throw new RuntimeException(e);
                        }
                        Toast.makeText(context, "Token: " + receivedToken, Toast.LENGTH_SHORT).show();
                        Intent myIntent = new Intent(context, MainActivity.class);
                        context.startActivity(myIntent);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (error.networkResponse == null){

                        }else{
                            int serverCode = error.networkResponse.statusCode;
                            Toast.makeText(context,"El servidor respondió con: " + serverCode,Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
        this.requestQueue.add(request);
    }
}
