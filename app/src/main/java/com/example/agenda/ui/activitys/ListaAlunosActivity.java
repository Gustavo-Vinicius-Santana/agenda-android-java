package com.example.agenda.ui.activitys;

import static com.example.agenda.ui.activitys.ConstantesActivities.CHAVE_ALUNO;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.agenda.R;
import com.example.agenda.dao.AlunoDAO;
import com.example.agenda.models.Aluno;
import com.example.agenda.ui.adapter.ListaAlunoAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ListaAlunosActivity extends AppCompatActivity {
    private final AlunoDAO dao = new AlunoDAO();

    public static final String TITLE_APPBAR = "lista de alunos";

    private ListaAlunoAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lista_alunos);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.lista_alunos), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mostrarLista();
        setTitle(TITLE_APPBAR);
        floatBtnOpenFormu();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.acticity_lista_alunos_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.activity_lista_alunos_menu_remover){

            confirmaRemocao(item);
        }

        return super.onContextItemSelected(item);
    }

    private void confirmaRemocao(@NonNull final MenuItem item) {
        new AlertDialog
                .Builder(this).setTitle("Removendo aluno")
                .setMessage("tem certeza que deseja remover o aluno?")
                .setPositiveButton("sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AdapterView.AdapterContextMenuInfo menuInfo =
                                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

                        Aluno alunoEscolhido = adapter.getItem(menuInfo.position);
                        removeAlun(alunoEscolhido);

                        Toast.makeText(ListaAlunosActivity.this,
                                "Aluno: " + alunoEscolhido + " foi removido", Toast.LENGTH_SHORT).show();

                    }
                })
                .setNegativeButton("não", null)
                .show();
    }

    private void floatBtnOpenFormu() {
        FloatingActionButton botaoNovoAluno = findViewById(R.id.activity_main_abrir_formulario);
        botaoNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abreFormularioModoInsereAluno();
            }
        });
    }

    private void abreFormularioModoInsereAluno() {
        startActivity(new Intent(this, FormularioAlunoActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();

        atualizaLista();
    }

    private void atualizaLista() {
        adapter.atualiza(dao.todos());
    }

    private void mostrarLista() {
        ListView listaAlunos = findViewById(R.id.activity_main_list_alun);
        configuraAdpter(listaAlunos);

        configuraListenerDeClick(listaAlunos);
        configuraListenerDeLongClick(listaAlunos);
        
        registerForContextMenu(listaAlunos);
    }

    private void configuraListenerDeLongClick(ListView listaAlunos) {
        listaAlunos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Aluno alunoClicado = (Aluno) parent.getItemAtPosition(position);

                return false;
            }
        });
    }

    private void removeAlun(Aluno alunoClicado) {
        dao.remove(alunoClicado);
        adapter.remove(alunoClicado);
    }

    private void configuraListenerDeClick(ListView listaAlunos) {
        listaAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Aluno alunoClicado = (Aluno) parent.getItemAtPosition(position);

                abreFormularioModoEditaAluno(alunoClicado);
            }
        });
    }

    private void abreFormularioModoEditaAluno(Aluno alunoClicado) {
        Intent vaiParaFormulario = new Intent(ListaAlunosActivity.this,
                FormularioAlunoActivity.class);

        vaiParaFormulario.putExtra(CHAVE_ALUNO, alunoClicado);
        startActivity(vaiParaFormulario);
    }

    private void configuraAdpter(ListView listaAlunos) {
        adapter = new ListaAlunoAdapter(this);
        listaAlunos.setAdapter(adapter);
    }
}
