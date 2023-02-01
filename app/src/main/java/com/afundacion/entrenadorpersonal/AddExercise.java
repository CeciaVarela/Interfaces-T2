package com.afundacion.entrenadorpersonal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
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
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        TextView timeTextViewCount = root.findViewById(R.id.text_view_timeCount);
        TextView caloryTextViewCount = root.findViewById(R.id.text_view_caloryCount);
        TextView idTextViewCount = root.findViewById(R.id.text_view_idCount);
        final int[] timeTotal = {0};
        final int[] caloriasTotales = {0};
        final int[] idsTotales = {0};

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
                        try {
                            JSONObject exercise = response.getJSONObject(0);
                            UsersData data = new UsersData(exercise);
                            int idUsuario = data.getId();
                            JsonArrayRequest request2 = new JsonArrayRequest(
                                    Request.Method.POST,
                                    "https://63be86bc585bedcb36af7637.mockapi.io/Users/"+String.valueOf(idUsuario)+"/Exercise",
                                    null,
                                    new Response.Listener<JSONArray>() {
                                        @Override
                                        public void onResponse(JSONArray response) {
                                            DateFormat df = new SimpleDateFormat("dd/MM/yy");
                                            for (int i = 0; i < response.length(); i++) {
                                                try {
                                                    JSONObject exercise = response.getJSONObject(i);
                                                    ExerciseData data = new ExerciseData(exercise);
                                                    Date bd = null;
                                                    try {
                                                        bd = df.parse(String.valueOf(data.getDate()));
                                                        long bdDate = System.currentTimeMillis();
                                                        if ((bdDate-bd.getTime()<=604800000)){
                                                            caloriasTotales[0] += data.getCalories();
                                                            timeTotal[0] += data.getTime();
                                                            idsTotales[0] += 1;
                                                        }
                                                    } catch (ParseException e) {
                                                        e.printStackTrace();
                                                    }
                                                } catch (JSONException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                            caloryTextViewCount.setText(String.valueOf(caloriasTotales[0]));
                                            timeTextViewCount.setText(String.valueOf(timeTotal[0]));
                                            idTextViewCount.setText(String.valueOf(idsTotales[0]));
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
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
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