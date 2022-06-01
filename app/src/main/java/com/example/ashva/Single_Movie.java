package com.example.ashva;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Single_Movie extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_movie);

        Intent intent = getIntent();
        String poster = intent.getStringExtra("Extra_poster");
        String title = intent.getStringExtra("Extra_title");
        String language = intent.getStringExtra("Extra_language");
        String overview = intent.getStringExtra("Extra_overview");
        String release = intent.getStringExtra("Extra_release");
        String rating = intent.getStringExtra("Extra_rating");

        TextView name, lang, over, rel, rat;
        ImageView post;

        post = findViewById(R.id.iv_movie_poster);
        name = findViewById(R.id.movie_title);
        lang = findViewById(R.id.movie_language);
        over = findViewById(R.id.movie_overview);
        rel = findViewById(R.id.movie_release_date);
        rat = findViewById(R.id.movie_rating);

        Picasso.with(this).load(poster).fit().centerInside().into(post);
        name.setText(title);
        lang.setText(language);
        over.setText(overview);
        rel.setText(release);
        rat.setText(rating);
    }
}
