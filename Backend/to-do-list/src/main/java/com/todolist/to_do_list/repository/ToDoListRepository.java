package com.todolist.to_do_list.repository;

import com.todolist.to_do_list.model.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {
}
