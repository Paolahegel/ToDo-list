package com.projects.todo.entity;

import com.projects.todo.entity.enums.TodoStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @Column(name = "realizado", nullable = false)
    private boolean realizado;
    private int prioridade;

    @Enumerated(EnumType.ORDINAL)
    private TodoStatus todoStatus;

    public Todo(String nome, String descricao, boolean realizado, int prioridade, TodoStatus todoStatus) {
        this.nome = nome;
        this.realizado = realizado;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.todoStatus = todoStatus;
    }
}
