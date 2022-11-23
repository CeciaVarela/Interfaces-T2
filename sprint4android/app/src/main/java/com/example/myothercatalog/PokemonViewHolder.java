package com.example.myothercatalog;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class PokemonViewHolder extends RecyclerView.ViewHolder {
    private final TextView textView;
    private final ImageView imageView;
    private final Button button;

    public PokemonViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.pokemon_name_text_view);
        imageView = (ImageView) itemView.findViewById(R.id.pokemon_image_view);
        button = (Button) itemView.findViewById(R.id.button);
    }
    public  void showData(PokemonData data, Activity activity){
        textView.setText(data.getName());
        cancelPreviousImageDownloadIfAny();
        loadImage(data.getImageUrl(), activity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(this, DetailActivity.class);
                startActivity(intent);
            }
        });
    }

    private void cancelPreviousImageDownloadIfAny() {}

    private void loadImage(String imageUrl, Activity activity) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Bitmap image = getBitmapFromUrl(imageUrl);
                activity.runOnUiThread(new  Runnable(){
                    @Override
                    public void run(){
                        imageView.setImageBitmap(image);
                    }
                }) ;
            }
        });
        thread.start();
    }

    private Bitmap getBitmapFromUrl (String urlString) {
        try {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap resultBitman = BitmapFactory.decodeStream(input);
            return resultBitman;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }


}