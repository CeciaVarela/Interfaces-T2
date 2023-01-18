package com.afundacion.entrenadorpersonal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
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

import java.util.ArrayList;
import java.util.List;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        TextView timeTextView = (TextView) findViewById(R.id.text_view_time);
        TextView caloryTextView = (TextView) findViewById(R.id.text_view_calory);
        final String[] time = new String[1];
        final int[] calory = new int[4];
        Activity activity = this;
        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                "https://63be86bc585bedcb36af7637.mockapi.io/Exercise",
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        List<ExerciseData> allTheExercises = new ArrayList<>();
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject exercise = response.getJSONObject(i);
                                ExerciseData data = new ExerciseData(exercise);
                                allTheExercises.add(data);
                                calory[i] = data.getCalories();
                                //time[0] = timeTextView.setText(data.getName().trim());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        caloryTextView.setText(calory[1]);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(activity,"Error", Toast.LENGTH_SHORT).show();
                    }
                });
        RequestQueue cola = Volley.newRequestQueue(this);
        cola.add(request);
    }
}