package com.example.SubtaskCRUD.controller;

import com.example.SubtaskCRUD.entity.SubtaskEntity;
import com.example.SubtaskCRUD.exception.SubtaskException;
import com.example.SubtaskCRUD.repository.SubtaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/subtask")
public class SubtaskController {

    @Autowired
    private SubtaskRepository subtaskRepository;

    @GetMapping
    public List<SubtaskEntity> getAllEmployee(){
        return subtaskRepository.findAll();
    }

    //build create employee REST API
    @PostMapping
    public SubtaskEntity createEmployee(@RequestBody SubtaskEntity subtask){
        return subtaskRepository.save(subtask);
    }

    //build get employee by id REST API
    @GetMapping({"id"})
    public ResponseEntity<SubtaskEntity> getEmployeeById(@PathVariable long id){
        SubtaskEntity subtask = subtaskRepository.findById(id)
                .orElseThrow(() -> new SubtaskException("Subtask not exist with id:" + id));
        return ResponseEntity.ok(subtask);
    }

    //build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<SubtaskEntity> updateSubtask(@PathVariable long id,@RequestBody SubtaskEntity subtaskDetails){
        SubtaskEntity updateSubtask = subtaskRepository.findById(id)
                .orElseThrow(() -> new SubtaskException("Employee not exist with id: " + id));

        updateSubtask.setName(subtaskDetails.getName());
        updateSubtask.setTitle(subtaskDetails.getTitle());
        updateSubtask.setJob(subtaskDetails.getJob());
        updateSubtask.setHireDate(subtaskDetails.getHireDate());
        updateSubtask.setSalary(subtaskDetails.getSalary());

        subtaskRepository.save(updateSubtask);
        return ResponseEntity.ok(updateSubtask);
    }

    //build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteSubtask(@PathVariable long id){

        SubtaskEntity employee = subtaskRepository.findById(id)
                .orElseThrow(() -> new SubtaskException("Subtask not exist with id: " + id));

        subtaskRepository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
