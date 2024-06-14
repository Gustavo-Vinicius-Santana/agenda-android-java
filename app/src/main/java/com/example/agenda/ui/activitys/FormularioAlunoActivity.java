package com.example.agenda.ui.activitys;

import static com.example.agenda.ui.activitys.ConstantesActivities.CHAVE_ALUNO;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

public class FormularioAlunoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR_NOVO_ALUNO = "Cadastro de alunos";
    public static final String TITULO_APPBAR_EDITA_ALUNO = "Editar aluno";
    private EditText campoNome;
    private EditText campoEmail;
    private EditText campoTelefone;
    private final AlunoDAO dao = new AlunoDAO();
    private Aluno aluno;

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

        iniciaCampos();

        carregaAluno();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_formulario_aluno_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.activity_formulario_aluno_menu_salvar){
            preencheAluno();
            finalizaFormulario();
        }
        return super.onOptionsItemSelected(item);
    }

    private void carregaAluno() {
        Intent dados = getIntent();
        if(dados.hasExtra(CHAVE_ALUNO)){
            setTitle(TITULO_APPBAR_EDITA_ALUNO);
            aluno = (Aluno) dados.getSerializableExtra(CHAVE_ALUNO);

            preencheCampos();
        }else{
            setTitle(TITULO_APPBAR_NOVO_ALUNO);
            aluno = new Aluno();
        }
    }

    private void preencheCampos() {
        campoNome.setText(aluno.getNome());
        campoEmail.setText(aluno.getEmail());
        campoTelefone.setText(aluno.getTelefone());
    }

    private void finalizaFormulario() {
        if(aluno.temIdValido()){
            dao.edita(aluno);
        }else{
            dao.salva(aluno);
        }
        finish();
    }

    private void iniciaCampos() {
        campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        campoEmail = findViewById(R.id.activity_formulario_aluno_email);
        campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
    }

    @NonNull
    public void preencheAluno(){
        String nome = campoNome.getText().toString();
        String email = campoEmail.getText().toString();
        String telefone = campoTelefone.getText().toString();

        aluno.setNome(nome);
        aluno.setEmail(email);
        aluno.setTelefone(telefone);
    }


}