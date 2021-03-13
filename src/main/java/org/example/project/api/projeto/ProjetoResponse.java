package org.example.project.api.projeto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProjetoResponse {
    public Integer codigo;
    public String titulo;
    public LocalDate data_inicio;
    public LocalDate data_fim;
    public Integer id_departamento;

    public ProjetoResponse(Projeto proj){
        this.codigo = proj.getCodigo();
        this.titulo = proj.getTitulo();
        this.data_inicio = proj.getData_inicio();
        this.data_fim = proj.getData_fim();
        this.id_departamento = proj.getDPTCodigo();

    }
}
