package org.example.project.api.departamento;

public class DepartamentoResponse {
    public int codigo;
    public String nome;
    public String sigla;

    public DepartamentoResponse(int codigo, String nome, String sigla) {
        this.codigo = codigo;
        this.nome = nome;
        this.sigla = sigla;
    }

    public DepartamentoResponse(Departamento dep){
        this.codigo = dep.getCodigo();
        this.nome = dep.getNome();
        this.sigla = dep.getSigla();
    }
}
