package org.example.project.api.departamento;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DepartamentoRequest {

    @NotNull
    @NotBlank
    @Size(min = 2, max =100)
    public String nome;

    @NotNull
    @NotBlank
    @Size(min = 2, max =100)
    public String sigla;
}
