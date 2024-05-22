package com.example.agenda.dao;

import com.example.agenda.models.Aluno;

import java.util.ArrayList;
import java.util.List;

public class alunoDAO {
    private final static List<Aluno> alunos = new ArrayList<>();
    public void salva(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }
}
