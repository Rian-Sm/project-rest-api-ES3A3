package org.example.project.api.funcionario;

public class FuncionarioResponse {
    public int id;
    public String nome;
    public String email;
    public int id_departamento;

    public FuncionarioResponse(Funcionario func){
        this.id = func.getId();
        this.nome = func.getNome();
        this.email = func.getEmail();
        this.id_departamento = func.getIdDepartamento();
    }

}
