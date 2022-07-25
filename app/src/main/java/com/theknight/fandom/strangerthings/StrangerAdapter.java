package com.theknight.fandom.strangerthings;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.theknight.fandom.R;
import com.theknight.fandom.lib.CharacterHolder;
import com.theknight.fandom.lib.ImageLoader;

import java.util.List;

public class StrangerAdapter extends RecyclerView.Adapter<CharacterHolder> {
    private static final String TAG = "StrangerAdapter";
    public List<StrangerModel> characters;
    Context context;

    public StrangerAdapter(Context context, List<StrangerModel> characters) {
        this.characters = characters;
        this.context = context;
    }

    @NonNull
    @Override
    public CharacterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: Before inflate");
        View view = LayoutInflater.from(context).inflate(R.layout.custom_cast, parent, false);
        Log.d(TAG, "onCreateViewHolder: After inflate");

        return new CharacterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterHolder holder, int position) {
        StrangerModel character = characters.get(position);

        ImageLoader loader = new ImageLoader();

        loader.loadImage(context, holder.imageView, character.getPhoto(), 700, 670);
        holder.age.setText(character.getGender());
//        holder.title.setText(character.getName());
//        holder.alt_name.setText(character.getBio().substring(0, 400));
//        holder.alt_name.setBackgroundResource(R.drawable.text_border);


        holder.name.setText(character.getName());
        holder.title.setText(character.getPortrayedBy());
        holder.cardView1.setBackgroundResource(R.drawable.cardview_border);


        Log.d(TAG, "onBindViewHolder: " + character.getPhoto());

    }

    @Override
    public int getItemCount() {
        return characters.size();
    }
}
