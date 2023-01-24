package com.afundacion.entrenadorpersonal;

import org.json.JSONException;
import org.json.JSONObject;

public class ExerciseData {
    private String name;
    private int time;
    private int calories;
    private String date;
    private String category;

    public ExerciseData(String name, int time, int calories, String date, String category) {
        this.name = name;
        this.time = time;
        this.calories = calories;
        this.date = date;
        this.category = category;
    }

    public ExerciseData(JSONObject json) {
        try {
            this.name = json.getString("name");
            this.time = json.getInt("time");
            this.calories = json.getInt("calories");
            this.date = json.getString("date");
            this.category = json.getString("category");
        } catch (JSONException error) {
            error.printStackTrace();
        }


    }

    public String getName() { return name; }

    public int getTime() { return time; }

    public int getCalories() { return  calories; }

    public String getDate() { return date; }

    public String getCategory() { return category; }

}