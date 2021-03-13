package org.example.project.api.projeto;

import org.example.project.api.funcionario.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class ProjetoRepository {
    private List<Projeto> projetos = new ArrayList<>();

    public Projeto create(Projeto proj){
        projetos.add(proj);
        return proj;
    }

    public List<Projeto> getAll(){
        return projetos;
    }

    public Projeto getProjetoById(int id){
        return projetos.stream().filter(proj -> proj.getCodigo() == id).findAny().orElse(null);
    }

    public Projeto update(Projeto newProj) {
        Projeto projFound = getProjetoById(newProj.getCodigo());
        int index = projetos.indexOf(projFound);
        projetos.set(index, newProj);

        return newProj;
    }

    public void delete(Projeto proj){
        projetos.remove(proj);
    }
}
