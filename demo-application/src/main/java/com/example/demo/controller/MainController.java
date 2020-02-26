package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MainController {

    @Autowired
    StudentServiceImpl studentService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String greeting1() {
        return "Hello SpringBoot form Get, ";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String greeting2() {
        return "Hello SpringBoot from Post";
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public Student getStudent(@PathVariable Integer id) {
        return studentService.getStudent(id);
    }
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ResponseEntity<Student> fetchStudent(@RequestParam Integer id) {
        Student student = studentService.getStudent(id);
        if (student ==null) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok().body(student);
        }

    }

//    @RequestMapping(value = "/student", method = RequestMethod.GET)
    @GetMapping(value = "/student")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }
}
