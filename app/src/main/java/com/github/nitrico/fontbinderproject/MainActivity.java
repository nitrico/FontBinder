package com.github.nitrico.fontbinderproject;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_main);

        // TextView textView = (TextView) findViewById(R.id.textView);

        // Java
        // textView.setTypeface(FontBinder.get("Alegreya-Bold"));

        // Kotlin
        // textView.typeface = FontBinder["Alegreya-Bold"]
    }

}
