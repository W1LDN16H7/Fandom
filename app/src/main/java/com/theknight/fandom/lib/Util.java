package com.theknight.fandom.lib;

import android.content.Context;
import android.text.TextUtils;
import android.view.Surface;
import android.view.WindowManager;

import java.util.List;

public class Util {
    public static String getRotation(Context context) {
        final int rotation = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getOrientation();
        switch ((int) rotation) {
            case Surface
                    .ROTATION_0:
                return "portrait";
            case Surface.ROTATION_90:
                return "landscape";


            case Surface.ROTATION_180:
                return "reverse_portrait";
            case Surface.ROTATION_270:
                return "reverse_landscape";

            default:
                return "unknown";
        }


    }

    public static String lstToString(List<String> strings) {
        /**
         * Convert
         */
        return TextUtils.join(", ", strings);

    }

}
