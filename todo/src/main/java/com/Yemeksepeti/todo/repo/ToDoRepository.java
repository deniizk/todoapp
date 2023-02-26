package com.Yemeksepeti.todo.repo;

import com.Yemeksepeti.todo.model.ToDoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDoModel, Long> {
}
