package com.theknight.fandom.marvel;

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

public class MarvelAdapter extends RecyclerView.Adapter<CharacterHolder> {
    private static final String TAG = "MarvelAdapter";
    public List<MarvelModel> characters;
    Context context;

    public MarvelAdapter(Context context, List<MarvelModel> characters) {
        this.characters = characters;
        this.context = context;
        Log.d(TAG, "MarvelAdapter: characters called ");
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
        MarvelModel character = characters.get(position);

        ImageLoader loader = new ImageLoader();

        loader.loadImage(context, holder.imageView, character.getImages().get(0), 770, 670);
        holder.age.setText(character.getGender());
        holder.title.setText(character.getTitle());
        holder.alt_name.setText(character.getBio().substring(0, 400));
        holder.alt_name.setBackgroundResource(R.drawable.text_border);


        holder.name.setText(character.getName());
        holder.cardView1.setBackgroundResource(R.drawable.cardview_border);


        Log.d(TAG, "onBindViewHolder: " + character.getImages().get(0));


    }

    @Override
    public int getItemCount() {
        return characters.size();
    }
}
