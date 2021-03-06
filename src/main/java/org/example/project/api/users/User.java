package org.example.project.api.users;

public class User {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private static int countId =1;

    public User(String nome, String email, String senha) {
        this.id = countId++;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public User(int id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
