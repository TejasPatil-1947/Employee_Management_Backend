package com.bacakend.controller;

import com.bacakend.Entity.Emp;
import com.bacakend.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1")
public class EmpController {

    @Autowired
    private EmpService empService;

    @PostMapping("/save")
    public ResponseEntity<Emp> createEmp(@RequestBody Emp emp){
        return new ResponseEntity<>(empService.createEmp(emp), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Emp>> getAllEmp(){
        return new ResponseEntity<List<Emp>>(empService.getAllEmp(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emp> getEmpById(@PathVariable int id){
        return new ResponseEntity<>(empService.getEmpById(id),HttpStatus.OK);
    }


    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmp(@PathVariable int id){
        empService.deleteEmp(id);
        return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Emp> updateEmp(@PathVariable int id, @RequestBody Emp emp){
        return new ResponseEntity<>(empService.updateEmp(id,emp),HttpStatus.OK);
    }

}
