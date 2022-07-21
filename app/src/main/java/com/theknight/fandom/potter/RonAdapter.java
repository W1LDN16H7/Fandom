package com.theknight.fandom.potter;

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

public class RonAdapter extends RecyclerView.Adapter<CharacterHolder> {

    private static final String TAG = "RonAdapter";
    public List<CharacterModel> characters;
    Context context;

    public RonAdapter(Context context, List<CharacterModel> characters) {
        this.characters = characters;
        this.context = context;
        Log.d(TAG, "RonAdapter: characters called ");
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
        CharacterModel character = characters.get(position);

        ImageLoader loader = new ImageLoader();

        loader.loadImage(context, holder.imageView, character.getImageUrl(), 190, 150);
        holder.age.setText(character.getGender());
        holder.name.setText(character.getName());

        Log.d(TAG, "onBindViewHolder: " + character.getImageUrl());

    }

    @Override
    public int getItemCount() {
        return characters.size();
    }
}
