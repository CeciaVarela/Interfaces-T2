package com.afundacion.entrenadorpersonal.Drawer;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.afundacion.entrenadorpersonal.UsersData;
import com.afundacion.entrenadorpersonal.R;
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

public class EjercicioFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context context = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            context = getContext();
        }
        View root = inflater.inflate(R.layout.fragment_ejercicio, container, false);
        EditText nameEditText = root.findViewById(R.id.exerciseName);
        EditText dateEditText = root.findViewById(R.id.exerciseDate);
        EditText durationEditText = root.findViewById(R.id.exerciseDuration);
        EditText caloriesEditText = root.findViewById(R.id.exerciseCalories);
        Spinner spinner = root.findViewById(R.id.category_spinner);
        Button button = (Button) root.findViewById(R.id.button_send);
        Context finalContext = context;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences prefs = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    prefs = getContext().getSharedPreferences("Users", Context.MODE_PRIVATE);
                }
                //String retrivedToken  = "token 1";
                String retrivedToken = prefs.getString("token","token 1");

                Context finalContext1 = finalContext;
                Context finalContext2 = finalContext;
                Context finalContext3 = finalContext;
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
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                        requestBody.put("category", spinner.getAutofillValue().getTextValue().toString());
                                    }
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
                                                Toast.makeText(finalContext, "Ejercicio añadido" , Toast.LENGTH_LONG).show();
                                            }
                                        },
                                        new Response.ErrorListener() {
                                            @Override
                                            public void onErrorResponse(VolleyError error) {
                                                Toast.makeText(finalContext1,"Error", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                RequestQueue cola2 = Volley.newRequestQueue(finalContext2);
                                cola2.add(request2);
                            }

                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(finalContext3, "Error", Toast.LENGTH_SHORT).show();
                            }
                        });
                RequestQueue cola = Volley.newRequestQueue(finalContext);
                cola.add(request);
            }
        });
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(context, R.array.exercises, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);



        return root;
    }

}