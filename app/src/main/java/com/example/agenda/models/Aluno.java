package com.example.agenda.models;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Aluno implements Serializable {
    private final String nome;
    private final String email;
    private final String telefone;

    public Aluno(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    @NonNull
    @Override
    public String toString() {
        return nome;
    }
}
