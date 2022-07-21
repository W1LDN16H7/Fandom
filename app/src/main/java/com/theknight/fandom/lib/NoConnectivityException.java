package com.theknight.fandom.lib;

import androidx.annotation.Nullable;

import java.io.IOException;

public class NoConnectivityException extends IOException {


    /**
     * Returns the detail message string of this throwable.
     *
     * @return the detail message string of this {@code Throwable} instance
     * (which may be {@code null}).
     */
    @Nullable
    @Override
    public String getMessage() {
        return "No Internet Connection ";

    }
}
