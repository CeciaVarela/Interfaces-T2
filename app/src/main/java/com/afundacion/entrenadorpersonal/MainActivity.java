package com.afundacion.entrenadorpersonal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;


import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    private List<Ejercicio> ejercicios = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                "https://63be86bc585bedcb36af7637.mockapi.io/Users/1/Exercise",
                null,
                new Response.Listener<JSONArray>(){
                    @Override
                    public void onResponse(JSONArray response){

                        for(int i = 0; i<response.length();i++){
                            try{
                                Ejercicio ejercicio1 = new Ejercicio();
                                JSONObject ejercicio = response.getJSONObject(i);
                                ejercicio1.setNombre(ejercicio.getString("name"));
                                ejercicio1.setTime(ejercicio.getInt("time"));

                                ejercicio1.setCalorias(ejercicio.getInt("calories"));
                                ejercicios.add(ejercicio1);
                            }catch(JSONException jsonE){
                                jsonE.printStackTrace();
                            }
                        }


                        RecyclerView ecRv = findViewById(R.id.rv_mep);
                        registerForContextMenu(ecRv);
                        ecRv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        ecRv.setAdapter(new MEPAdapter(ejercicios));
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
        RequestQueue cola = Volley.newRequestQueue(this);
        cola.add(request);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        RecyclerView mepRv = findViewById(R.id.rv_mep);
        MEPAdapter adapter = (MEPAdapter)mepRv.getAdapter();
        int position = -1;
        try {
            position = adapter.getPosition();
        } catch (Exception e) {
            return super.onContextItemSelected(item);
        }
        switch (item.getItemId()) {
            case 1:
                // editar
                break;
            case 2:
                ejercicios.remove(position);
                adapter.notifyDataSetChanged();
                break;
        }
        return super.onContextItemSelected(item);
    }
}