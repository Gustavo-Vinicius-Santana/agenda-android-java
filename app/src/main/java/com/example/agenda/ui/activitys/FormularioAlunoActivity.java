package com.example.agenda.ui.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.agenda.R;
import com.example.agenda.dao.alunoDAO;
import com.example.agenda.models.Aluno;

import org.jetbrains.annotations.Nullable;

public class FormularioAlunoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_formulario_aluno);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        alunoDAO dao = new alunoDAO();

        final EditText campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        final EditText campoEmail = findViewById(R.id.activity_formulario_aluno_email);
        final EditText campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);

        Button botaoSalvar = findViewById(R.id.activity_formulario_aluno_btn_enviar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = campoNome.getText().toString();
                String email = campoEmail.getText().toString();
                String telefone = campoTelefone.getText().toString();

                Aluno alunoCriado = new Aluno(nome, email, telefone);
                dao.salva(alunoCriado);

                finish();
            }
        });
    }
}