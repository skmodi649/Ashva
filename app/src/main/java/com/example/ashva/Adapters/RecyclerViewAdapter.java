package com.example.ashva.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ashva.R;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.ashva.Single_Movie;
import com.example.ashva.models.MovieModel;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private ArrayList<MovieModel> mData ;
    RequestOptions option;


    public RecyclerViewAdapter(Context mContext, ArrayList<MovieModel> mData) {
        this.mContext = mContext;
        this.mData = mData;

        // Request option for Glide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_image).error(R.drawable.loading_image);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.list_item,parent,false) ;
        final MyViewHolder viewHolder = new MyViewHolder(view) ;
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext, Single_Movie.class);
                i.putExtra("movie_id",mData.get(viewHolder.getAdapterPosition()).getId());
                i.putExtra("movie_title",mData.get(viewHolder.getAdapterPosition()).getTitle());
                i.putExtra("movie_language",mData.get(viewHolder.getAdapterPosition()).getLanguage());
                i.putExtra("movie_overview",mData.get(viewHolder.getAdapterPosition()).getOverview());
                i.putExtra("movie_poster_path",mData.get(viewHolder.getAdapterPosition()).getPoster_path());
                i.putExtra("movie_release_date",mData.get(viewHolder.getAdapterPosition()).getRelease_date());
                i.putExtra("movie_rating",mData.get(viewHolder.getAdapterPosition()).getRating());

                mContext.startActivity(i);

            }
        });




        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.movie_name.setText(mData.get(position).getTitle());
        holder.movie_rating.setText(mData.get(position).getRating());

        // Load Image from the internet and set it into Imageview using Glide

        Glide.with(mContext).load(mData.get(position).getPoster_path()).apply(option).into(holder.movie_image);



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView movie_name ;
        TextView movie_rating ;
        ImageView movie_image;
        ConstraintLayout view_container;





        public MyViewHolder(View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.single_row);
            movie_name = itemView.findViewById(R.id.movie_name);
            movie_rating = itemView.findViewById(R.id.movie_rating);
            movie_image = itemView.findViewById(R.id.movie_poster);
        }
    }

}