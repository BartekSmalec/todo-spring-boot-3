package com.bartek.todospringboot3.service;

import com.bartek.todospringboot3.todo.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private static final List<Todo> todos;

    private static int todosCount = 0;

    static {
        todos = new ArrayList<>();
        todos.add(new Todo(todosCount++, "in28minutes", "Learn AWS Certificate", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(todosCount++, "in28minutes", "Learn DevOps", LocalDate.now().plusYears(2), false));
        todos.add(new Todo(todosCount++, "in28minutes", "Learn Full Stack Development", LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUsername(String username) {
        return todos.stream()
                .filter(t -> t.getUsername().equalsIgnoreCase(username))
                .collect(Collectors.toList());
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
        Todo todo = new Todo(++todosCount, username, description, targetDate, done);
        todos.add(todo);
    }

    public void deleteById(int id) {
        Predicate<Todo> deletePredicate = n -> n.getId() == id;
        todos.removeIf(deletePredicate);
    }

    public Todo findById(int id) {
        Predicate<Todo> findById = n -> n.getId() == id;
        return todos.stream().filter(findById).findFirst().get();
    }

    public void updateTodo(Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}
