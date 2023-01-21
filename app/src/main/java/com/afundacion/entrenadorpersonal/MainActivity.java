package com.afundacion.entrenadorpersonal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GraphView graph = (GraphView) findViewById(R.id.graph);

        List<DataPoint> tareasCompletas = new ArrayList<>();
        tareasCompletas.add(new DataPoint(0, 8));
        tareasCompletas.add(new DataPoint(1, 3));
        tareasCompletas.add(new DataPoint(2, 5));
        tareasCompletas.add(new DataPoint(3, 10));
        tareasCompletas.add(new DataPoint(4, 12));
        tareasCompletas.add(new DataPoint(5, 7));
        tareasCompletas.add(new DataPoint(7, 14));
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(tareasCompletas.toArray(new
                DataPoint[tareasCompletas.size()]));
        series.setTitle("Completadas");
        graph.addSeries(series);

        List<DataPoint> tareasPendientes = new ArrayList<>();
        tareasPendientes.add(new DataPoint(0, 6));
        tareasPendientes.add(new DataPoint(1, 11));
        tareasPendientes.add(new DataPoint(2, 9));
        tareasPendientes.add(new DataPoint(3, 4));
        tareasPendientes.add(new DataPoint(4, 2));
        tareasPendientes.add(new DataPoint(5, 7));
        tareasPendientes.add(new DataPoint(7, 0));
        LineGraphSeries<DataPoint> seriePendiente = new LineGraphSeries<>(tareasPendientes.toArray(new
                DataPoint[tareasPendientes.size()]));
        seriePendiente.setColor(R.color.purple_200);
        seriePendiente.setTitle("Pendientes");
        graph.addSeries(seriePendiente);

        graph.getLegendRenderer().setVisible(true);


    }
}