package com.afundacion.entrenadorpersonal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddExercise extends AppCompatActivity {

    private final Context context = null;
    public void onCreate(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View root = inflater.inflate(R.layout.activity_add_exercise, container, false);
        EditText nameEditText = root.findViewById(R.id.exerciseName);
        EditText dateEditText = root.findViewById(R.id.exerciseDate);
        EditText durationEditText = root.findViewById(R.id.exerciseDuration);
        EditText caloriesEditText = root.findViewById(R.id.exerciseCalories);
        Spinner spinner = root.findViewById(R.id.category_spinner);
        Button button = (Button) findViewById(R.id.button_send);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
            }
        });
        ArrayAdapter<CharSequence>adapter= ArrayAdapter.createFromResource(this, R.array.exercises, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        SharedPreferences prefs = getSharedPreferences("Users", Context.MODE_PRIVATE);
        //String retrivedToken  = "token 1";
        String retrivedToken = prefs.getString("token",null);

        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                "https://63be86bc585bedcb36af7637.mockapi.io/Users/?token="+retrivedToken,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        JSONObject exercise = null;
                        try {
                            exercise = response.getJSONObject(0);
                        } catch (JSONException ex) {
                            ex.printStackTrace();
                        }
                        UsersData data = new UsersData(exercise);
                        int idUsuario = data.getId();
                        JSONObject requestBody = new JSONObject();
                        try {
                            requestBody.put("name", nameEditText.getText().toString());
                            requestBody.put("date", dateEditText.getText().toString());
                            requestBody.put("time", durationEditText.getText().toString());
                            requestBody.put("calories", caloriesEditText.getText().toString());
                            requestBody.put("category", spinner.toString());
                            requestBody.put("UserId", String.valueOf(idUsuario));
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                        JsonObjectRequest request2 = new JsonObjectRequest(
                                Request.Method.POST,
                                "https://63be86bc585bedcb36af7637.mockapi.io/Users/"+String.valueOf(idUsuario)+"/Exercise",
                                requestBody,
                                new Response.Listener<JSONObject>() {
                                    @Override
                                    public void onResponse(JSONObject response) {
                                        Toast.makeText(context, "Ejercicio añadido" , Toast.LENGTH_LONG).show();
                                        finish();
                                    }
                                },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        Toast.makeText(context,"Error", Toast.LENGTH_SHORT).show();
                                    }
                                });
                        RequestQueue cola2 = Volley.newRequestQueue(context);
                        cola2.add(request2);
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
        RequestQueue cola = Volley.newRequestQueue(context);
        cola.add(request);
    }
}