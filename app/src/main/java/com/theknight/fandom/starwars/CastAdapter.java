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
    public List<CharacterModel> characters;
    Context context;

    public CastAdapter(Context context, List<CharacterModel> characters) {
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
        CharacterModel character = characters.get(position);

        ImageLoader loader = new ImageLoader();

        loader.loadImage(context, holder.imageView, character.getUrl(), 190, 150);
        holder.age.setText(character.getGender());
        holder.name.setText(character.getName());

        Log.d(TAG, "onBindViewHolder: " + character.getUrl());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(context, CharacterInfo.class);
                intent.putExtra("name", character.getName());
                intent.putExtra("height", character.getHeight());
                intent.putExtra("mass", character.getMass());
                intent.putExtra("hair_color", character.getHair_color());
                intent.putExtra("skin_color", character.getSkin_color());
                intent.putExtra("eye_color", character.getEye_color());
                intent.putExtra("gender", character.getGender());
                intent.putExtra("url", character.getUrl());
                intent.putExtra("born", character.getBorn());
                intent.putExtra("died", character.getDied());
                intent.putExtra("wiki_url", character.getWiki_url());
                intent.putExtra("born_location", character.getBorn_location());
                intent.putExtra("died_location", character.getDied_location());
                intent.putExtra("species", character.getSpecies());
                intent.putExtra("apprentices", character.getApprentices());
                intent.putExtra("affiliations", character.getAffiliations());
                intent.putExtra("masters", character.getMaster());
                intent.putExtra(" formerAffiliations", character.getFormerAffiliations());

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
            age = itemView.findViewById(R.id.former);
        }
    }
}
