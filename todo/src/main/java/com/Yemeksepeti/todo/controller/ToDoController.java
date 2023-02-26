package com.Yemeksepeti.todo.controller;

import com.Yemeksepeti.todo.model.ToDoModel;
import com.Yemeksepeti.todo.repo.ToDoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api")
@AllArgsConstructor
public class ToDoController {

    private ToDoRepository toDoRepository;

    @GetMapping(path = "todo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ToDoModel>> getAll()
    {
        //localhost:9090/api/todo
        return ResponseEntity.ok(toDoRepository.findAll());
    }

    @GetMapping(path = "todo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable(value = "id") Long id)
    {
        //localhost:9090/api/todo/1
        return ResponseEntity.ok(toDoRepository.findById(id));
    }

    @PostMapping(path = "todo", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ToDoModel> save(@RequestBody ToDoModel toDoModel)
    {
        //localhost:9090/api/todo
        /* {
            "title": "Finish project",
            "description": "Finish the ToDo application project",
            "duedate": "2023-03-01",
            "complated": false
        }*/
        return ResponseEntity.ok(toDoRepository.save(toDoModel));
    }

    @PutMapping(path = "todo/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ToDoModel> update(@PathVariable Long id, @RequestBody ToDoModel toDoModel)
    {
        //localhost:9090/api/todo/1
       /* {
            "title": "Finish project",
            "description": "Finish the ToDo application project",
            "duedate": "2023-03-01",
            "complated": false
        }*/
        toDoModel.setID(id);
        return ResponseEntity.ok(toDoRepository.save(toDoModel));
    }

    @DeleteMapping(path = "todo/{id}")
    public void delete(@PathVariable(value = "id") Long id)
    {
        //localhost:9090/api/todo/1
        toDoRepository.deleteById(id);
    }
}
