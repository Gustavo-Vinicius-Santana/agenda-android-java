package com.example.agenda.models;

import androidx.annotation.NonNull;

public class Aluno {
    private final String nome;
    private final String email;
    private final String telefone;

    public Aluno(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    @NonNull
    @Override
    public String toString() {
        return nome;
    }
}
