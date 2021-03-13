package org.example.project.api.projeto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class ProjetoRequest {
    @NotNull
    @NotBlank
    @Size(min = 2, max=100)
    public String titulo;

    @JsonFormat(pattern="yyyy-MM-dd")
    @FutureOrPresent
    public LocalDate data_inicio;

    @JsonFormat(pattern="yyyy-MM-dd")
    @FutureOrPresent
    public LocalDate data_fim;

    @Positive
    public Integer id_departamento;
}
