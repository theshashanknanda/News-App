package com.example.newsapp.Actvities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.newsapp.Adapters.RecyclerViewAdapter;
import com.example.newsapp.R;
import com.example.newsapp.Utils.Model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public RecyclerView recyclerView;
    public List<Model> newsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        getNews("https://api.currentsapi.services/v1/latest-news?language=en&apiKey=l0lMTLABROQRNmbWhtNqb8c1OXIpdZQ6-cMF6AN66OtvVSnd");
    }

    public void getNews(String url){

        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject object = new JSONObject(response);

                            JSONArray jsonArray = object.getJSONArray("news");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                Model model = new Model();
                                model.setAuthor(jsonObject.getString("author"));
                                model.setTitle(jsonObject.getString("title"));
                                model.setDescription(jsonObject.getString("description"));
                                model.setSourceURL(jsonObject.getString("url"));
                                model.setImageURL(jsonObject.getString("image"));
                                model.setPublished(jsonObject.getString("published"));

                                newsList.add(model);
                            }

                            RecyclerViewAdapter adapter = new RecyclerViewAdapter(newsList, MainActivity.this);
                            recyclerView.setAdapter(adapter);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);
    }
}

