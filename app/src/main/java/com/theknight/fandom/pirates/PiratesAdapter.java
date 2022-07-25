package com.theknight.fandom.pirates;

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

public class PiratesAdapter extends RecyclerView.Adapter<CharacterHolder> {

    private static final String TAG = "PiratesAdapter";
    public List<PiratesModel> characters;
    Context context;

    public PiratesAdapter(Context context, List<PiratesModel> characters) {
        this.characters = characters;
        this.context = context;
        Log.d(TAG, "PiratesAdapter: characters called ");
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
        PiratesModel character = characters.get(position);

        ImageLoader loader = new ImageLoader();

        loader.loadImage(context, holder.imageView, character.getImage(), 750, 650);
        holder.age.setText(character.getGender());
//        holder.alt_name.setText(character.getAbout().substring(0,character.getAbout().length()/2));
//        holder.alt_name.setBackgroundResource(R.drawable.text_border);


        holder.name.setText(character.getName());
        holder.cardView1.setBackgroundResource(R.drawable.cardview_border);


        Log.d(TAG, "onBindViewHolder: " + character.getImage());

    }

    @Override
    public int getItemCount() {
        return characters.size();
    }
}
