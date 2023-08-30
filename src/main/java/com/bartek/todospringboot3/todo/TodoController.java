package com.bartek.todospringboot3.todo;

import com.bartek.todospringboot3.repository.TodoRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@AllArgsConstructor
@SessionAttributes("name")
public class TodoController {

    private TodoRepository todoRepository;

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap map) {
        String name = getLoggedUsername(map);
        map.put("todos", todoRepository.findByUsername(name));
        return "listTodos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPAge(ModelMap map) {
        Todo todo = new Todo(0, getLoggedUsername(map), "", LocalDate.now().plusYears(1), false);
        map.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap map, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        String name = getLoggedUsername(map);

        Todo newTodo = Todo.builder()
                .username(name)
                .description(todo.getDescription())
                .targetDate(todo.getTargetDate())
                .done(todo.isDone())
                .build();

        todoRepository.save(newTodo);
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoRepository.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String updateTodoPage(@RequestParam int id, ModelMap map) {
        Optional<Todo> todo = todoRepository.findById(id);
        map.put("todo", todo.get());
        return "todo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap map, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        todo.setUsername(getLoggedUsername(map));
        todoRepository.save(todo);
        return "redirect:list-todos";
    }

    private static String getLoggedUsername(ModelMap map) {
        return (String) map.get("name");
    }
}
