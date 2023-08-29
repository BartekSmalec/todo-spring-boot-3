package com.bartek.todospringboot3.todo;

import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Todo {
    private int id;
    private String username;
    @Size(min=10, message = "Enter at least 10 characters")
    private String description;
    private LocalDate targetDate;
    private boolean done;
}
