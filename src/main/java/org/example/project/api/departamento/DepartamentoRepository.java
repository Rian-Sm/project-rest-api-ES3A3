package org.example.project.api.departamento;

import java.util.ArrayList;
import java.util.List;

public class DepartamentoRepository {
    private List<Departamento> departamentos = new ArrayList<>();

    public Departamento save(Departamento dep){
        this.departamentos.add(dep);
        return dep;
    }

    public List<Departamento> getAll() {
        return departamentos;
    }

    public Departamento getDepartamentoByid(int codigo){
        return departamentos.stream()
                .filter(dep -> dep.getCodigo() == codigo)
                .findAny().orElse(null);
    }

    public Departamento update (Departamento dep){
        Departamento depFound = getDepartamentoByid(dep.getCodigo());
        int index = departamentos.indexOf(depFound);
        departamentos.set(index, dep);

        return dep;
    }




}
