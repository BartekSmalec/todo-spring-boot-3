package com.bartek.todospringboot3.todo;

import com.bartek.todospringboot3.service.TodoService;
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

@Controller
@AllArgsConstructor
@SessionAttributes("name")
public class TodoController {
    private TodoService todoService;
    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap map) {
        map.put("todos", todoService.findByUsername("in28minutes"));
        return "listTodos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPAge(ModelMap map) {
        Todo todo = new Todo(0, (String) map.get("name"), "", LocalDate.now().plusYears(1), false);
        map.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap map, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        String name = (String) map.get("name");
        todoService.addTodo(name, todo.getDescription() ,LocalDate.now().plusYears(1), false);
        return "redirect:list-todos";
    }
}
