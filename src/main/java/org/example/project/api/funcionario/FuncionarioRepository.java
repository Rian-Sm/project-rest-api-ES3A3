package org.example.project.api.funcionario;

import org.example.project.api.departamento.Departamento;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepository {
    private List<Funcionario> funcionarios = new ArrayList<>();

    public Funcionario save(Funcionario func){
        this.funcionarios.add(func);
        return func;
    }

    public List<Funcionario> getAll() { return funcionarios; }

    public Funcionario getFuncionarioById(int id) {
        return funcionarios.stream()
                .filter(func -> func.getId()==id)
                .findAny().orElse(null);
    }

    public Funcionario update (Funcionario func){
        Funcionario depFound = getFuncionarioById(func.getId());
        int index = funcionarios.indexOf(depFound);
        funcionarios.set(index, func);

        return func;
    }

    public void delete(Funcionario func){
        this.funcionarios.remove(func);
    }

    public boolean cpfEqual(Funcionario func) {
        for (Funcionario funcionario : funcionarios ){
            if (funcionario.getCpf() == func.getCpf())
                return true;
        }

        return false;
    }
}
