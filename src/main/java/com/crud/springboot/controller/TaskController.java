package com.crud.springboot.controller;

import com.crud.springboot.model.Task;
import com.crud.springboot.repository.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/tasks")
public class TaskController {
    //operations crud

    @Autowired
    private ITaskRepository taskRepository;


    @GetMapping("")
    List<Task> index(){
        return taskRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    Task create(@RequestBody Task task){
        return taskRepository.save(task);
    }

    @PutMapping("{id}")
    Task update(@PathVariable String id,@RequestBody Task task){
        Task taskFromDb = taskRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);

        taskFromDb.setName(task.getName());
        taskFromDb.setCompleted(task.isCompleted());

        return taskRepository.save(taskFromDb);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void delete(@PathVariable String id){
        Task task = taskRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);

        taskRepository.delete(task);
    }




}
