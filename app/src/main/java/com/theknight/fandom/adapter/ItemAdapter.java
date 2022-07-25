package com.theknight.fandom.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.theknight.fandom.R;
import com.theknight.fandom.lib.ImageLoader;
import com.theknight.fandom.marvel.MarvelActivity;
import com.theknight.fandom.pirates.PiratesActivity;
import com.theknight.fandom.potter.Potter;
import com.theknight.fandom.starwars.StarWarsActivity;
import com.theknight.fandom.strangerthings.StrangerActivity;

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
        holder.genre.setText(movieModel.getGenres().replace(",", "|"));
        holder.years.setText(movieModel.getYears_active());
        holder.layout.setBackgroundResource(R.drawable.cardview_border);
        holder.mview.setOnClickListener(new View.OnClickListener() {
            private final String TAG = ItemAdapter.class.getName();

            @Override
            public void onClick(View v) {
                Log.d("RecyclerView", "onClick：" + holder.getAdapterPosition());

                switch (holder.getAdapterPosition()) {
                    case 0:
                        Intent intent3 = new Intent(context, StrangerActivity.class);
                        context.startActivity(intent3);
                        break;

                    case 1:
                        Intent intent = new Intent(v.getContext(), StarWarsActivity.class);
                        intent.putExtra("url1", movieModel.getImages().get(0));
                        intent.putExtra("url2", movieModel.getImages().get(1));

                        v.getContext().startActivity(intent);
                        break;
                    case 2:
                        Intent intent1 = new Intent(context, Potter.class);
                        context.startActivity(intent1);
                        break;
                    case 3:
                        Intent intent4 = new Intent(context, PiratesActivity.class);
                        context.startActivity(intent4);
                        break;

                    case 4:
                        Intent intent2 = new Intent(context, MarvelActivity.class);
                        context.startActivity(intent2);
                        break;

                    default:
                        break;

                }


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
        TextView title, genre, years;
        com.theknight.fandom.lib.ScrollTextView desc;
        MaterialButton info;
        CardView cardView;
        LinearLayout layout;
        public final View mview;


        public ItemViewHandler(@NonNull View itemView) {
            super(itemView);
            mview = itemView;

            imageView = itemView.findViewById(R.id.view_image);
            title = itemView.findViewById(R.id.item_title);
            genre = itemView.findViewById(R.id.genres);
            years = itemView.findViewById(R.id.years);
            desc = itemView.findViewById(R.id.desc);
            info = itemView.findViewById(R.id.info);
            layout = itemView.findViewById(R.id.constraintLayout);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Log.d("RecyclerView", "onClick：" + getAdapterPosition());
//                }
//            });
        }
    }
}
