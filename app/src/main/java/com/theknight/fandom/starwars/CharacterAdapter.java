package com.theknight.fandom.starwars;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.theknight.fandom.R;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterHolder> {

    private static final String TAG = "$className";
    public List<Character> characters;
    Context context;

    public CharacterAdapter(Context context,List<Character> characters) {
        this.characters = characters;
        this.context = context;
        Log.d(TAG, "CharacterAdapter: characters called ");

    }




    @NonNull
    @Override
    public CharacterAdapter.CharacterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: Before inflate");
        View view = LayoutInflater.from(context).inflate(R.layout.custom_character,parent,false);
        Log.d(TAG, "onCreateViewHolder: After inflate");

        return new CharacterHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CharacterAdapter.CharacterHolder holder, int position) {
        Character character = characters.get(position);
        holder.real_name.setText(character.getReal_name());
        holder.name.setText(character.getName());
        holder.imageView.setImageResource(character.getImage());


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
        TextView real_name;


        public CharacterHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.avatar);
            name= itemView.findViewById(R.id.charector_name);
            real_name = itemView.findViewById(R.id.real_name);
        }
    }
}
