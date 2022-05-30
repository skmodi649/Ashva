package com.example.ashva;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.ashva.models.MovieModel;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
    Context context;
    ArrayList<MovieModel> modelClass;

    // RequestOption for Glide

    RequestOptions requestOptions;

    public MovieAdapter(Context context , ArrayList<MovieModel> modelClass){
        this.context = context;
        this.modelClass = modelClass;

        requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_image).error(R.drawable.loading_image);
    }

    @NonNull
    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This is where we are going to inflate the layout (Basically giving a look to the rows)

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item, parent, false);

        final MyViewHolder viewHolder = new MyViewHolder(view) ;

        // Making each row of the recycler view clickable and then passing the value to the single movie activity

        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, Single_Movie.class);
                i.putExtra("movie_name",modelClass.get(viewHolder.getAdapterPosition()).getTitle());
                i.putExtra("movie_language",modelClass.get(viewHolder.getAdapterPosition()).getLanguage());
                i.putExtra("movie_overview",modelClass.get(viewHolder.getAdapterPosition()).getOverview());
                i.putExtra("movie_rating",modelClass.get(viewHolder.getAdapterPosition()).getRating());
                i.putExtra("movie_poster",modelClass.get(viewHolder.getAdapterPosition()).getPoster_path());
                i.putExtra("movie_release_date",modelClass.get(viewHolder.getAdapterPosition()).getRelease_date());
                context.startActivity(i);

            }
        });




        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MyViewHolder holder, int position) {
        // assigning values to the views we created in the recycler_view_row layout file
        // based on the position of the recycler view

        holder.name.setText(modelClass.get(position).getTitle());
        holder.rating.setText(modelClass.get(position).getRating());


        // Load Image from the internet and set it into Imageview using Glide

        Glide.with(context).load(modelClass.get(position).getPoster_path()).apply(requestOptions).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        // the recycler view just wants to know the number of items you want to be displayed
        return modelClass.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public View view_container;
        // grabbing the views from our recycler_view_row layout file
        // kinda like in the onCreate method

        ImageView imageView;
        TextView name, rating;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.movie_poster);
            name = itemView.findViewById(R.id.movie_name);
            rating = itemView.findViewById(R.id.movie_rating);
        }
    }
}
