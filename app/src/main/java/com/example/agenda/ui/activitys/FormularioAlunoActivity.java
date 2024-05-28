package com.example.agenda.ui.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.agenda.R;
import com.example.agenda.dao.AlunoDAO;
import com.example.agenda.models.Aluno;

import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

public class FormularioAlunoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Cadastro de alunos";
    private EditText campoNome;
    private EditText campoEmail;
    private EditText campoTelefone;
    private AlunoDAO dao = new AlunoDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_formulario_aluno);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.formulario_aluno), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setTitle(TITULO_APPBAR);

        inicializaçãoDosCampos();
        botaoSalvarAluno();

        Intent dados = getIntent();
        Aluno aluno = (Aluno) dados.getSerializableExtra("aluno");

        campoNome.setText(aluno.getNome());
        campoEmail.setText(aluno.getEmail());
        campoTelefone.setText(aluno.getTelefone());
    }

    private void botaoSalvarAluno() {
        Button botaoSalvar = findViewById(R.id.activity_formulario_aluno_btn_enviar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Aluno alunoCriado = getAlunoCriado();
                salvarAluno(alunoCriado);
            }
        });
    }

    private void inicializaçãoDosCampos() {
        campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        campoEmail = findViewById(R.id.activity_formulario_aluno_email);
        campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
    }

    private void salvarAluno(Aluno alunoCriado) {
        dao.salva(alunoCriado);
        finish();
    }

    @NonNull
    private Aluno getAlunoCriado() {
        String nome = campoNome.getText().toString();
        String email = campoEmail.getText().toString();
        String telefone = campoTelefone.getText().toString();

        Aluno alunoCriado = new Aluno(nome, email, telefone);
        return alunoCriado;
    }


}