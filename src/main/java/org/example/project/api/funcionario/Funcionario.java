package org.example.project.api.funcionario;

import org.example.project.api.departamento.Departamento;

public class Funcionario {
    private Integer id;
    private String cpf;
    private String nome;
    private String email;
    private int id_departameto;
    private static int countCodigo =1;

    public Funcionario(String cpf, String nome, String email, int id_departameto) {
        this.id = countCodigo++;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.id_departameto = id_departameto;
    }
    public Funcionario(int id,String cpf, String nome, String email, int id_departameto) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.id_departameto = id_departameto;
    }

    public int getId() {return id;}

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() { return email; }

    public int getIdDepartamento() {
        return id_departameto;
    }

    @Override
    public String toString() {
        return cpf + " - " + nome + ", " + email + ", " + id_departameto;
    }
}
