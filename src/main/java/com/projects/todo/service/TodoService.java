package com.projects.todo.service;

import com.projects.todo.entity.Todo;
import com.projects.todo.entity.enums.TodoStatus;
import com.projects.todo.exceptions.TodoNotFoundException;
import com.projects.todo.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public List<Todo> create(Todo todo){
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> list(){
        Sort sort = Sort.by("prioridade").descending()
                .and(Sort.by("nome").ascending());
        return todoRepository.findAll(sort);
    }

    public List<Todo> update(Todo todo){
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> delete(Long id){
        todoRepository.deleteById(id);
        return list();
    }

    public List<Todo> deleteAll(){
        todoRepository.deleteAll();
        return list();
    }

    public List<Todo> findByStatus(TodoStatus status){
        return todoRepository.findByStatus(status);
    }

    public List<Todo> searchByName(String searchTerm) {
        List<Todo> result = todoRepository.findByName(searchTerm);
        if (result == null || result.isEmpty()) {
            throw new TodoNotFoundException(searchTerm);
        }
        return result;
    }
}
