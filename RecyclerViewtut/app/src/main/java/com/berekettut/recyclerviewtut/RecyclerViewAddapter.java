package com.berekettut.recyclerviewtut;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAddapter extends RecyclerView.Adapter<RecyclerViewAddapter.ViewHolder> {
    public static final String TAG = "RECYVELERVIEWADDAPTER";

    ArrayList<String> titles;


    Context context;

    public RecyclerViewAddapter(ArrayList<String> titles) {
        this.titles = titles;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyvlerview_holder, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Log.d(TAG, "onBindViewHolder");
        // is possible to use Glide to load images from url
       // Glide.with(context).asBitmap().load(imageUrls.get(i)).into(viewHolder.image);

        viewHolder.textView.setText(titles.get(i));

    }

    @Override
    public int getItemCount() {
        return this.titles.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView image;
        TextView textView;
        LinearLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.profile_image);
            textView = itemView.findViewById(R.id.textView);
            layout = itemView.findViewById(R.id.recycler_view_layout);
        }
    }
}
