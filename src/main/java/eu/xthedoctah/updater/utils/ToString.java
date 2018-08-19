package eu.xthedoctah.updater.utils;

import com.google.gson.Gson;

public class ToString {
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
