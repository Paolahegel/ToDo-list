package com.projects.todo.dto;

import com.projects.todo.entity.enums.TodoStatus;
import jakarta.validation.constraints.NotBlank;

public record TodoRequestDTO(
        @NotBlank String nome,
        @NotBlank String descricao,
        int prioridade,
        TodoStatus status,
        boolean realizado
    )  {}
