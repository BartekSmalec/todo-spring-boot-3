package com.bartek.todospringboot3.todo;

import com.bartek.todospringboot3.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

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
}
