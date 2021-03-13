package org.example.project.api.funcionario;

import jakarta.validation.constraints.*;

public class FuncionarioRequest {
    @NotNull
    @NotBlank
    @Size(min = 2, max =100)
    public String nome;
    @NotNull
    @NotBlank
    @Size(min = 14, max =14)
    public String CPF;
    @NotNull
    @NotBlank
    @Email
    public String email;
    @Positive
    public int id_departamento;
}
