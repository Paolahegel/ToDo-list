package com.projects.todo.dto;

import com.projects.todo.entity.enums.TodoStatus;

public record TodoResponseDTO(
        Long id,
        String nome,
        String descricao,
        int prioridade,
        TodoStatus status,
        boolean realizado
    ) {}
