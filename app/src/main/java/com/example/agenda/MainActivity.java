package com.example.agenda;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(this, "Hello world!", Toast.LENGTH_LONG).show();

        TextView mensage = new TextView(this);
        mensage.setText("hello world!");
        setContentView(mensage);
    }
}
