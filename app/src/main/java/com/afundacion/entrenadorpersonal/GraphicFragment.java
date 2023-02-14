package com.afundacion.entrenadorpersonal;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.session.MediaSession;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.TokenWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GraphicFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GraphicFragment extends Fragment {

    public GraphicFragment() {
        // Required empty public constructor
    }


    public static GraphicFragment newInstance() {
        GraphicFragment fragment = new GraphicFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_graphic, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //private MediaSession.Token token = new TokenWatcher("name");
        GraphView graph = (GraphView) view.findViewById(R.id.graph);
        JSONObject exercise = null;
        SharedPreferences prefs = requireContext().getSharedPreferences("SESSIONS_APP_PREFS", Context.MODE_PRIVATE);
        final int id = prefs.getInt("ID", -1);
        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                "https://63be86bc585bedcb36af7637.mockapi.io/Users/"+String.valueOf(id)+"/Exercise",
                null,
                response -> {
                    List<DataPoint> ejercicios = new ArrayList<>();

                    for(int i = 0; i<response.length();i++){
                        try{
                            JSONObject ejercicio = response.getJSONObject(i);
                            DataPoint data = new DataPoint(i, ejercicio.getInt("calories"));
                            ejercicios.add(data);
                        }catch(JSONException jsonE){
                            jsonE.printStackTrace();
                        }
                    }
                    LineGraphSeries<DataPoint> seriePendiente = new LineGraphSeries<>(ejercicios.toArray(new DataPoint[0]));
                    graph.addSeries(seriePendiente);
                    graph.getLegendRenderer().setVisible(true);

                },
                error -> Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show());
        RequestQueue cola = Volley.newRequestQueue(requireContext());
        cola.add(request);
    }
}