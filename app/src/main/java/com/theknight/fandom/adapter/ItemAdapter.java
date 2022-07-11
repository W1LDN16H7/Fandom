package com.theknight.fandom.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.nfc.Tag;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.theknight.fandom.R;
import com.theknight.fandom.starwars.StarWarsActivity;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHandler> {
    public List<MovieData> movieData;

    public ItemAdapter(List<MovieData> movieData) {
        this.movieData = movieData;
    }

    @NonNull
    @Override
    public ItemViewHandler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item,parent,false);

        return new ItemViewHandler(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ItemViewHandler holder, int position) {
        MovieData movie = movieData.get(position);
        System.out.println(movie.getTitle()  + movie.getDesc());
        holder.title.setText(movie.getTitle());
        holder.desc.setVerticalScrollBarEnabled(true);
        holder.desc.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        holder.desc.setMarqueeRepeatLimit(-1);
        holder.desc.setText(movie.getDesc());
        holder.imageView.setImageResource(movie.getImage());
        holder.mview.setOnClickListener(new View.OnClickListener() {
            private final String TAG = ItemAdapter.class.getName();

            @Override
            public void onClick(View v) {
                Log.d("RecyclerView", "onClick：" + holder.getAdapterPosition());
                Toast.makeText(v.getContext(), "Item clicked " +holder.getAdapterPosition() ,Toast.LENGTH_LONG ).show();

                Intent intent = new Intent(v.getContext(), StarWarsActivity.class);

                v.getContext().startActivity(intent);

                Log.d(TAG, "onClick: launching activity ");



            }
        });


    }





    @Override
    public int getItemCount() {
        return movieData.size();
    }

    public static class ItemViewHandler extends RecyclerView.ViewHolder{


        ImageView imageView;
        TextView title;
        com.theknight.fandom.lib.ScrollTextView desc;
        MaterialButton info;
        CardView cardView;
        public final View mview;


        public ItemViewHandler(@NonNull View itemView) {
            super(itemView);
            mview = itemView;

            imageView = itemView.findViewById(R.id.view_image);
            title = itemView.findViewById(R.id.item_title);
            desc = itemView.findViewById(R.id.desc);
            info = itemView.findViewById(R.id.info);
            cardView = itemView.findViewById(R.id.card);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Log.d("RecyclerView", "onClick：" + getAdapterPosition());
//                }
//            });
        }
    }
}
