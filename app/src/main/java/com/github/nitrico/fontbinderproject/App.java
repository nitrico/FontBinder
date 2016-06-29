package com.github.nitrico.fontbinderproject;

import android.app.Application;
import com.github.nitrico.fontbinder.FontBinder;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FontBinder.INSTANCE.init(this);
    }

}
