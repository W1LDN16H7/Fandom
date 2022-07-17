package com.theknight.fandom.starwars;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.theknight.fandom.R;
import com.theknight.fandom.lib.ImageLoader;

public class CharacterInfo extends AppCompatActivity {

    private static final String TAG = "CharacterInfo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_info);
        Log.d(TAG, "onCreate: layout created");
        getIncomingIntent();

    }

    private void getIncomingIntent() {
        TextView name, height, mass, hair_color, skin_color, eye_color, gender, homeworld, born, died, born_location, died_location, species, apprentices, masters, formerAffiliations, affiliations = null;
        ImageView imageView;
        String wiki_url;
        WebView wiki;
        String url;
        name = findViewById(R.id.name_value);
        height = findViewById(R.id.height_value);
        hair_color = findViewById(R.id.haircolor_value);
        mass = findViewById(R.id.mass_value);
        skin_color = findViewById(R.id.skincolor_value);
        eye_color = findViewById(R.id.eyecolor_value);
        gender = findViewById(R.id.gender_value);
        imageView = findViewById(R.id.image_character);
        born = findViewById(R.id.born_value);
        died = findViewById(R.id.died_location_value);
        wiki = findViewById(R.id.about_value);
        species = findViewById(R.id.species_value);
        born_location = findViewById(R.id.born_location_value);
        apprentices = findViewById(R.id.apprentices_value);
        affiliations = findViewById(R.id.affiliations_value);
        masters = findViewById(R.id.master_value);
        formerAffiliations = findViewById(R.id.formerAffiliations_value);


        Log.d(TAG, "getIncomingIntent: Checking intent");

        name.setText(getValue("name"));
        height.setText(getValue("height"));
        hair_color.setText(getValue("hair_color"));
        eye_color.setText(getValue("eye_color"));
        skin_color.setText(getValue("skin_color"));
        gender.setText(getValue("gender"));
        url = getValue("url");
        born.setText(getValue("born"));
        died.setText(getValue("died"));
        wiki_url = getValue("wiki_url");
        born_location.setText(getValue("born_location"));
        died.setText(getValue("died_location"));
        species.setText(getValue("species"));
        apprentices.setText(getValue("apprentices"));
        affiliations.setText(getValue("affiliations"));
        masters.setText(getValue("masters"));
        formerAffiliations.setText(getValue("formerAffiliations"));
        ImageLoader imageLoader = new ImageLoader();
        imageLoader.loadImage(this, imageView, url, 190, 150);


    }

    private String getValue(String field) {
        String value;
        if (getIntent().hasExtra(field)) {
            value = getIntent().getStringExtra(field);
            return value;


        }
        return "null";
    }
}