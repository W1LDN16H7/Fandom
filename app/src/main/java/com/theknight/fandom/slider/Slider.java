package com.theknight.fandom.slider;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.github.appintro.AppIntro;
import com.github.appintro.AppIntroFragment;
import com.github.appintro.AppIntroPageTransformerType;
import com.theknight.fandom.R;

public class Slider extends AppIntro {


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        addSlide(AppIntroFragment.createInstance("", "", R.drawable.logo, R.color.dark


                )


        );

        addSlide(AppIntroFragment.createInstance("Star Wars", "Powerful you have become, the dark side i sense in you.", 0, 0, R.color.yellow, R.color.yoda, R.font.starjout, R.font.strjmono, R.drawable.starwars


                )


        );

        addSlide(AppIntroFragment.createInstance("Now that you’ve seen where I’ve been, I’d like very much to show you where I am going.", "", 0, 0, R.color.eleven, 0, R.font.strangerthings, R.font.font_fandom, R.drawable.strt


                )


        );

        addSlide(AppIntroFragment.createInstance("Harry Potter", "\n" +
                        "Wingardium Leviosaaaaa", 0, 0, R.color.hp1, R.color.hp ,R.font.strangerthings, R.font.font_fandom, R.drawable.hp


                )


        );
        addSlide(AppIntroFragment.createInstance("Lord of the rings", "All we have to decide is what to do with the time that is given us", 0, 0, android.R.color.holo_orange_light, android.R.color.holo_green_light, R.font.font_fandom, R.font.font_fandom, R.drawable.lotr


                )


        );

        addSlide(AppIntroFragment.createInstance("Pirates of the Caribbean", "This is the day you will always remember as the day you almost caught Captain Jack Sparrow", 0, 0, R.color.yoda2, R.color.royal_blue,R.font.strangerthings,R.font.strangerthings, R.drawable.depp


                )


        );


        // Fade Transition


        setTransformer(AppIntroPageTransformerType.Fade.INSTANCE);

        // Show/hide status bar
        setImmersiveMode();
        showStatusBar(false);

        //Speed up or down scrolling
        setScrollDurationFactor(2);


        //Prevent the back button from exiting the slides
        setSystemBackButtonLocked(true);

        //Activate wizard mode (Some aesthetic changes)

        //Show/hide skip button
        setSkipButtonEnabled(true);

        //Enable immersive mode (no status and nav bar)

        //Enable/disable page indicators
        setIndicatorEnabled(true);

        //Dhow/hide ALL buttons
        setButtonsEnabled(true);
//        setIndicatorColor(
//                getResources().getColor(R.color.purple_700),
//                getResources().getColor(R.color.white_bright)
//        );
    }

    @Override
    protected void onSkipPressed(@Nullable Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        finish();
    }

    @Override
    protected void onDonePressed(@Nullable Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        finish();
    }


}
