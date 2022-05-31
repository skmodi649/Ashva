package com.example.ashva;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ashva.models.MovieModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    public static ArrayList<MovieModel> MovieModelList = new ArrayList<>();
    MovieModel movieModel;
    MovieAdapter myCustomAdapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Attaching the adapter to the recycler view

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        fetchData();

        // Create the adapter after the models are setup

        MovieAdapter adapter = new MovieAdapter(this, MovieModelList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void fetchData(){

        String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=496624d35e26fc516f231af5af837238&language=en-US&page=1";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Now we have to handle the JSON text
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for(int i = 0;i<jsonArray.length();i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String Movie_id = jsonObject.getString("id");
                        String Movie_name = jsonObject.getString("title");
                        String Movie_language = jsonObject.getString("original_language");
                        String image = jsonObject.getString("poster_path");
                        String release_date = jsonObject.getString("release_date");
                        String rating = jsonObject.getString("vote_average");
                        String overview = jsonObject.getString("overview");

                        movieModel = new MovieModel(Movie_id,Movie_name,Movie_language,overview,image,release_date,rating);
                        MovieModelList.add(movieModel);
                    }

                    myCustomAdapter = new MovieAdapter(MainActivity.this, MovieModelList);
                    listView.setAdapter((ListAdapter) myCustomAdapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}