package org.example.project.api.projeto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Projeto {
    private Integer codigo;
    private String titulo;
    private LocalDate data_inicio;
    private LocalDate data_fim;
    private Integer id_departamento;
    private static int genCodigo =1;

    public Projeto(String titulo, LocalDate  data_inicio, LocalDate  data_fim, Integer departamento_codigo){
        this.codigo = genCodigo++;
        this.titulo = titulo;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.id_departamento = departamento_codigo;
    }
    public Projeto(Integer codigo, String titulo, LocalDate  data_inicio, LocalDate  data_fim, Integer departamento_codigo){
        this.codigo = codigo;
        this.titulo = titulo;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.id_departamento = departamento_codigo;
    }

    //getters
    public Integer getCodigo() {
        return codigo;
    }
    public String getTitulo() {
        return titulo;
    }
    public LocalDate  getData_inicio() {
        return data_inicio;
    }
    public LocalDate  getData_fim() {
        return data_fim;
    }
    public Integer getDPTCodigo() {
        return id_departamento;
    }

    @Override
    public String toString() {
        return this.getCodigo() + ", " + this.getTitulo() + ", departamento codigo:" + this.getDPTCodigo();
    }


}
