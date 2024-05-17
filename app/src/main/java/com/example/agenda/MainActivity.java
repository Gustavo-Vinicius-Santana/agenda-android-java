package com.example.agenda;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
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

        setContentView(R.layout.activity_main);

        List<String> alunos = new ArrayList<>(Arrays.asList("Alex", "Fran", "josé", "maria"));

        TextView primeiroAluno = findViewById(R.id.textView);
        TextView segundoAluno = findViewById(R.id.textView2);
        TextView terceiroAluno = findViewById(R.id.textView3);
        TextView quartoAluno = findViewById(R.id.textView4);

        primeiroAluno.setText(alunos.get(0));
        segundoAluno.setText(alunos.get(1));
        terceiroAluno.setText(alunos.get(2));
        quartoAluno.setText(alunos.get(3));
    }
}
