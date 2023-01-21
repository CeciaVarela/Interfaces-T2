package com.afundacion.entrenadorpersonal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<Ejercicio> ejercicios = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        [{"time":58,"calories":22,"name":"name 1","date":"17/01/2023","category":"category 1","id":"1"},
        {"time":30,"calories":40,"name":"name 2","date":"04/01/2023","category":"category 2","id":"2"},
        {"time":60,"calories":94,"name":"name 3","date":"02/01/2023","category":"category 3","id":"3"},
        {"time":50,"calories":20,"name":"name 4","date":"20/12/2022","category":"category 4","id":"4"},
        {"time":86,"calories":77,"name":"name 5","date":"12/12/2023","category":"category 5","id":"5"}]
         */


        Ejercicio ejercicio1 = new Ejercicio();
        Ejercicio ejercicio2 = new Ejercicio();
        Ejercicio ejercicio3 = new Ejercicio();
        Ejercicio ejercicio4 = new Ejercicio();
        Ejercicio ejercicio5 = new Ejercicio();

        ejercicio1.setNombre("name 1");
        ejercicio2.setNombre("name 2");
        ejercicio3.setNombre("name 3");
        ejercicio4.setNombre("name 4");
        ejercicio5.setNombre("name 5");

        ejercicio1.setTime(58);
        ejercicio2.setTime(30);
        ejercicio3.setTime(60);
        ejercicio4.setTime(50);
        ejercicio5.setTime(86);

        ejercicio1.setCalorias(22);
        ejercicio2.setCalorias(40);
        ejercicio3.setCalorias(94);
        ejercicio4.setCalorias(20);
        ejercicio5.setCalorias(77);

        ejercicios.add(ejercicio1);
        ejercicios.add(ejercicio2);
        ejercicios.add(ejercicio3);
        ejercicios.add(ejercicio4);
        ejercicios.add(ejercicio5);

        RecyclerView ecRv = findViewById(R.id.rv_mep);
        registerForContextMenu(ecRv);
        ecRv.setLayoutManager(new LinearLayoutManager(this));
        ecRv.setAdapter(new MEPAdapter(ejercicios));
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