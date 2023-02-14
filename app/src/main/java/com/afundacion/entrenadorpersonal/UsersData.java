package com.afundacion.entrenadorpersonal;

import org.json.JSONException;
import org.json.JSONObject;

public class UsersData {
    private String name;
    private String email;
    private String password;
    private String confirmdpassword;
    private String token;
    private int id;

    public UsersData(String name, String email, String password, String confirmdpassword, String token, int id) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmdpassword = confirmdpassword;
        this.token = token;
        this.id = id;
    }
    

    public UsersData(JSONObject json) {
        try {
            this.name = json.getString("name");
            this.email = json.getString("email");
            this.password = json.getString("password");
            this.confirmdpassword = json.getString("confirmdpassword");
            this.token = json.getString("token");
            this.id = json.getInt("id");
        } catch (JSONException error) {
            error.printStackTrace();
        }


    }



    public int getId() { return id; }


}