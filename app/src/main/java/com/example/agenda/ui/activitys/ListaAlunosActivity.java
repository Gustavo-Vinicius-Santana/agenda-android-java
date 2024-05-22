package com.example.agenda.ui.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.example.agenda.R;
import com.example.agenda.dao.alunoDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListaAlunosActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lista_alunos);
        setTitle("lista de alunos");

        FloatingActionButton botaoNovoAluno = findViewById(R.id.activity_main_abrir_formulario);
        botaoNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        alunoDAO dao = new alunoDAO();
        ListView listaAlunos = findViewById(R.id.activity_main_list_alun);
        listaAlunos.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                dao.todos()));
    }
}
