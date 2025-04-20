package com.projects.todo.entity;

import com.projects.todo.entity.enums.TodoStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    @Column(name = "Título")
    @NotBlank
    private String nome;

    @Column(name = "Descrição")
    @NotBlank
    private String descricao;

    @Column(name = "Prioridade")
    private int prioridade;

    @Column(name = "Status")
    @Enumerated(EnumType.STRING)
    private TodoStatus status;

    @Column(name = "Realizado", nullable = false)
    private boolean realizado;


    public Todo(){}

    public Todo(String nome, String descricao, boolean realizado, int prioridade, TodoStatus status) {
        this.nome = nome;
        this.realizado = realizado;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.status = status;
    }
}
