package com.example.ashva;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
    Context context;
    ArrayList<ModelClass> modelClass;

    public MovieAdapter(Context context , ArrayList<ModelClass> modelClass){
        this.context = context;
        this.modelClass = modelClass;
    }

    @NonNull
    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This is where we are going to inflate the layout (Basically giving a look to the rows)

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item, parent, false);

        return new MovieAdapter.MyViewHolder(view); // instead of returning null, return a new MovieAdapter
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MyViewHolder holder, int position) {
        // assigning values to the views we created in the recycler_view_row layout file
        // based on the position of the recycler view

        holder.name.setText(modelClass.get(position).getMovie_name());
        holder.rating.setText(modelClass.get(position).getRating());
        holder.imageView.setImageResource(modelClass.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        // the recycler view just wants to know the number of items you want to be displayed
        return modelClass.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
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
