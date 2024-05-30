package com.example.agenda.dao;

import com.example.agenda.models.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    private final static List<Aluno> alunos = new ArrayList<>();
    private static int contadorDeIds = 1;
    public void salva(Aluno aluno) {
        aluno.setId(contadorDeIds);
        alunos.add(aluno);
        contadorDeIds++;
    }

    public void edita(Aluno aluno){
        Aluno alunoEcontrado = null;
        alunoEcontrado = buscaAlunoPorId(aluno);

        if(alunoEcontrado != null){
            int positionAluno = alunos.indexOf(alunoEcontrado);
            alunos.set(positionAluno, aluno);
        }
    }

    private static Aluno buscaAlunoPorId(Aluno aluno) {
        for (Aluno a: alunos) {
            if(a.getId() == aluno.getId()){
                return a;
            }
        }
        return null;
    }

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }

    public void remove(Aluno aluno) {
        Aluno alunoDevolvido = buscaAlunoPorId(aluno);

        if(alunoDevolvido != null){
            alunos.remove(alunoDevolvido);
        }
    }
}
