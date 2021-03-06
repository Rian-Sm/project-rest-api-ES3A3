package org.example.project.api.departamento;

public class Departamento {
    private int codigo;
    private String nome;
    private String sigla;
    private static int countCodigo =1;

    public Departamento (String nome, String sigla) {
        this.codigo = countCodigo++;
        this.nome = nome;
        this.sigla = sigla;

    }

    public Departamento(int codigo, String nome, String sigla) {
        this.codigo = codigo;
        this.nome = nome;
        this.sigla = sigla;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

    @Override
    public String toString() {
        return codigo + ", " + nome + ", " + sigla;
    }
}
