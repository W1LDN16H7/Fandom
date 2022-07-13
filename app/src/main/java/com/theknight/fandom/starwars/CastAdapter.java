package com.theknight.fandom.starwars;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.theknight.fandom.R;
import com.theknight.fandom.lib.ImageLoader;

import java.util.List;

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.CharacterHolder> {

    private static final String TAG = "$className";
    public List<Character> characters;
    Context context;

    public CastAdapter(Context context, List<Character> characters) {
        this.characters = characters;
        this.context = context;
        Log.d(TAG, "CastAdapter: characters called ");

    }


    @NonNull
    @Override
    public CastAdapter.CharacterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: Before inflate");
        View view = LayoutInflater.from(context).inflate(R.layout.custom_cast, parent, false);
        Log.d(TAG, "onCreateViewHolder: After inflate");

        return new CharacterHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CastAdapter.CharacterHolder holder, int position) {
        Character character = characters.get(position);

        ImageLoader loader = new ImageLoader();

        loader.loadImage(context, holder.imageView, character.getUrl());
        holder.age.setText(character.getAge());
        holder.name.setText(character.getName());

        Log.d(TAG, "onBindViewHolder: " + character.getUrl());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CharacterInfo.class);
                v.getContext().startActivity(intent);
                Log.d(TAG, "onClick: launching activity ");

            }
        });


    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return characters.size();
    }

    public static class CharacterHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name;
        TextView age;


        public CharacterHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.avatar);
            name = itemView.findViewById(R.id.charector_name);
            age = itemView.findViewById(R.id.age);
        }
    }
}
