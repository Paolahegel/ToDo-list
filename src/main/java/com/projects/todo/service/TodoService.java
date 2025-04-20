package com.projects.todo.service;

import com.projects.todo.dto.TodoRequestDTO;
import com.projects.todo.dto.TodoResponseDTO;
import com.projects.todo.entity.Todo;
import com.projects.todo.entity.enums.TodoStatus;
import com.projects.todo.exceptions.TodoNotFoundException;
import com.projects.todo.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public List<TodoResponseDTO> create(TodoRequestDTO todoRequest) {
        Todo todo = new Todo();
        todo.setNome(todoRequest.nome());
        todo.setDescricao(todoRequest.descricao());
        todo.setPrioridade(todoRequest.prioridade());
        todo.setStatus(todoRequest.status());
        todo.setRealizado(todoRequest.realizado());

        todoRepository.save(todo);
        return list();
    }

    public List<TodoResponseDTO> list() {
        Sort sort = Sort.by("prioridade").descending()
                .and(Sort.by("nome").ascending());

        return todoRepository.findAll(sort).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<TodoResponseDTO> update(TodoRequestDTO todoRequest) {
        Todo todo = new Todo();
        todo.setNome(todoRequest.nome());
        todo.setDescricao(todoRequest.descricao());
        todo.setPrioridade(todoRequest.prioridade());
        todo.setStatus(todoRequest.status());
        todo.setRealizado(todoRequest.realizado());

        todoRepository.save(todo);
        return list();
    }

    public List<TodoResponseDTO> delete(Long id) {
        todoRepository.deleteById(id);
        return list();
    }

    public List<TodoResponseDTO> deleteAll() {
        todoRepository.deleteAll();
        return list();
    }

    public List<TodoResponseDTO> findByStatus(TodoStatus status) {
        return todoRepository.findByStatus(status).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<TodoResponseDTO> searchByName(String searchTerm) {
        List<Todo> result = todoRepository.findByName(searchTerm);
        if (result == null || result.isEmpty()) {
            throw new TodoNotFoundException(searchTerm);
        }
        return result.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private TodoResponseDTO convertToDTO(Todo todo) {
        return new TodoResponseDTO(
                todo.getId(),
                todo.getNome(),
                todo.getDescricao(),
                todo.getPrioridade(),
                todo.getStatus(),
                todo.isRealizado()
        );
    }
}
