package com.todolist.to_do_list.service;

import com.todolist.to_do_list.model.ToDoList;
import com.todolist.to_do_list.repository.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoListService {

    @Autowired
    private ToDoListRepository toDoListRepository;


    // Listar todas as tarefas
    public List<ToDoList> listarTodas() {
        return toDoListRepository.findAll();
    }

    // Buscar tarefa por ID
    public ToDoList buscarPorId(Long id) {
        return toDoListRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada com ID: " + id));
    }


    // Criar nova tarefa
    public ToDoList criar(ToDoList toDoList) {
        return toDoListRepository.save(toDoList);
    }

    // Atualizar tarefa
    public ToDoList atualizar(Long id, ToDoList toDoListAtualizada) {
        ToDoList existente = buscarPorId(id);

        existente.setTitulo(toDoListAtualizada.getTitulo());
        existente.setDescricao(toDoListAtualizada.getDescricao());
        existente.setConcluido(toDoListAtualizada.isConcluido());

        return toDoListRepository.save(existente);
    }

    // Deletar tarefa
    public void deletar(Long id) {
        ToDoList existente = buscarPorId(id);
        toDoListRepository.delete(existente);
    }
}
