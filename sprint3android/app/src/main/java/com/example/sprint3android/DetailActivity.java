package com.example.sprint3android;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        CircleImageView civ = (CircleImageView) findViewById(R.id.image_camiseta);
        TextView miTexto = (TextView) findViewById(R.id.camiseta);
        miTexto.setText("Camiseta");
        civ.setImageResource(R.drawable.camiseta);
        TextView description = (TextView) findViewById(R.id.camiseta_description);
        description.setText("Es una prenda de ropa interior de abrigo por lo general de mangas cortas, cuello redondo o en forma de V");
    }
}
