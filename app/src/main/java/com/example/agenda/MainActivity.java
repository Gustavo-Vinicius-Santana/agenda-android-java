package com.example.agenda;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(this, "Hello world!", Toast.LENGTH_LONG).show();

        setContentView(R.layout.activity_main_lista_alunos);

        List<String> alunos = new ArrayList<>(Arrays.asList("Alex", "Fran", "josé", "maria"));

        ListView listaAlunos = findViewById(R.id.activity_main_list_alun);

        listaAlunos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alunos));

    }
}
