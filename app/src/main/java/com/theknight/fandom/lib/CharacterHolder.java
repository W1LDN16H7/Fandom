package com.theknight.fandom.lib;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.theknight.fandom.R;

public class CharacterHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView name, title, alt_name;
    public TextView age;
    public CardView cardView1, cardView2;


    public CharacterHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.avatar);
        name = itemView.findViewById(R.id.charector_name);
        title = itemView.findViewById(R.id.char_title);
        alt_name = itemView.findViewById(R.id.char_bio);

        age = itemView.findViewById(R.id.char_gender);
        cardView1 = itemView.findViewById(R.id.cardvew1);
        cardView2 = itemView.findViewById(R.id.cardvew2);
    }
}