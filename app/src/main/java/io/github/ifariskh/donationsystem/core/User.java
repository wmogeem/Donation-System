package io.github.ifariskh.donationsystem.core;

import android.content.Context;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import io.github.ifariskh.donationsystem.helper.Constant;

public class User {
    private String fullName;
    private String email;
    private String id;
    private String phone;
    private String dob;

    public User(String fullName, String email, String id, String phone, String dob) {
        this.fullName = fullName;
        this.email = email;
        this.id = id;
        this.phone = phone;
        this.dob = dob;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void register(String password, Context ctx){
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Constant.REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("id", id);
                map.put("fullname", fullName);
                map.put("email", email);
                map.put("password", password);
                map.put("phone", phone);
                map.put("dob", dob);
                return map;
            }
        };

        RequestHandler.getInstance(ctx).addToRequestQueue(stringRequest);
    }
}
