package com.example.ashva;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Single_Movie extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_movie);

        // Changing the color of action bar of the following activity
        // Define ActionBar object
        ActionBar actionBar;
        actionBar = getSupportActionBar();

        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#B18F88"));

        // Set BackgroundDrawable
        actionBar.setBackgroundDrawable(colorDrawable);

        // Changing the title of the action bar of the current activity
        actionBar.setTitle("Movie Details");



        Intent intent = getIntent();
        String poster = intent.getStringExtra("Extra_poster");
        String title = intent.getStringExtra("Extra_title");
        String language = intent.getStringExtra("Extra_language");
        String overview = intent.getStringExtra("Extra_overview");
        String release = intent.getStringExtra("Extra_release");
        String rating = intent.getStringExtra("Extra_rating");
        String count = intent.getStringExtra("Extra_Vote_Count");

        TextView name, lang, over, rel, rat, vote;
        ImageView post;

        post = findViewById(R.id.iv_movie_poster);
        name = findViewById(R.id.movie_title);
        lang = findViewById(R.id.movie_language);
        over = findViewById(R.id.movie_overview);
        rel = findViewById(R.id.movie_release_date);
        rat = findViewById(R.id.movie_rating);
        vote = findViewById(R.id.movie_vote_count);
        String image_url = "https://image.tmdb.org/t/p/w780/" + poster;

        Picasso.with(this).load(image_url).fit().centerInside().into(post);
        name.setText(title);
        lang.setText(language);
        over.setText(overview);
        rel.setText(release);
        rat.setText(rating);
        vote.setText(count);
    }
}
