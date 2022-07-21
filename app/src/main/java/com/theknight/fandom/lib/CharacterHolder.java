package com.theknight.fandom.lib;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.theknight.fandom.R;

public class CharacterHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView name;
    public TextView age;


    public CharacterHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.avatar);
        name = itemView.findViewById(R.id.charector_name);
        age = itemView.findViewById(R.id.char_gender);
    }
}