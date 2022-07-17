package com.theknight.fandom.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.theknight.fandom.R;
import com.theknight.fandom.lib.ImageLoader;
import com.theknight.fandom.starwars.StarWarsActivity;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHandler> {
    public List<MovieModel> movieData;
    Context context;

    public ItemAdapter(Context context, List<MovieModel> movieData) {
        this.movieData = movieData;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHandler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item, parent, false);

        return new ItemViewHandler(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ItemViewHandler holder, int position) {
        MovieModel movieModel = movieData.get(position);

        System.out.println(movieModel.getTitle() + movieModel.getStoryline());
        holder.title.setText(movieModel.getTitle());
        holder.desc.setVerticalScrollBarEnabled(true);
        holder.desc.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        holder.desc.setMarqueeRepeatLimit(-1);
        holder.desc.setText(movieModel.getStoryline());
        ImageLoader loader = new ImageLoader();
        loader.loadImage(context, holder.imageView, movieModel.getImages().get(0));
        holder.mview.setOnClickListener(new View.OnClickListener() {
            private final String TAG = ItemAdapter.class.getName();

            @Override
            public void onClick(View v) {
                Log.d("RecyclerView", "onClick：" + holder.getAdapterPosition());
                Toast.makeText(v.getContext(), "Item clicked " + holder.getAdapterPosition(), Toast.LENGTH_LONG).show();

                Intent intent = new Intent(v.getContext(), StarWarsActivity.class);
                intent.putExtra("url1", movieModel.getImages().get(0));
                intent.putExtra("url2", movieModel.getImages().get(1));

                v.getContext().startActivity(intent);

                Log.d(TAG, "onClick: launching activity ");


            }
        });


    }





    @Override
    public int getItemCount() {
        return movieData.size();
    }

    public static class ItemViewHandler extends RecyclerView.ViewHolder {


        ImageView imageView, imageView2;
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
