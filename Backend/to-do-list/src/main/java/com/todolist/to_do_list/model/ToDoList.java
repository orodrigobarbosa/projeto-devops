package com.todolist.to_do_list.model;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "todo_list")
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descricao;

    private boolean concluido = false;
}
