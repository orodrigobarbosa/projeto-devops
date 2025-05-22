package com.todolist.to_do_list.controller;

import com.todolist.to_do_list.model.ToDoList;
import com.todolist.to_do_list.service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
@CrossOrigin(origins = "*")  // Libera o CORS para facilitar cesso do frontend
public class ToDoListController {

    @Autowired
    private ToDoListService toDoListService;

    // Listar todas as tarefas
    @GetMapping
    public ResponseEntity<List<ToDoList>> listarTodas() {
        return ResponseEntity.ok(toDoListService.listarTodas());
    }

    // Buscar tarefa por ID
    @GetMapping("/{id}")
    public ResponseEntity<ToDoList> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(toDoListService.buscarPorId(id));
    }

    // Criar nova tarefa
    @PostMapping
    public ResponseEntity<ToDoList> criar(@RequestBody ToDoList toDoList) {
        return ResponseEntity.ok(toDoListService.criar(toDoList));
    }

    // Atualizar tarefa
    @PutMapping("/{id}")
    public ResponseEntity<ToDoList> atualizar(@PathVariable Long id, @RequestBody ToDoList toDoList) {
        return ResponseEntity.ok(toDoListService.atualizar(id, toDoList));
    }

    // Deletar tarefa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        toDoListService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
