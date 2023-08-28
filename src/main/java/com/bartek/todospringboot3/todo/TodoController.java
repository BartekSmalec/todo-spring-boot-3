package com.bartek.todospringboot3.todo;

import com.bartek.todospringboot3.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    public String showNewTodoPAge() {
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo(@RequestParam String description, ModelMap map) {
        String name = (String) map.get("name");
        todoService.addTodo(name,description ,LocalDate.now().plusYears(1), false);
        return "redirect:list-todos";
    }
}
