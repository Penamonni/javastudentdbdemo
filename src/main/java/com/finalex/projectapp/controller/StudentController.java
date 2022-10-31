package com.finalex.projectapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finalex.projectapp.data.Student;
import com.finalex.projectapp.service.Studentservice;

@RestController
public class StudentController {

    @Autowired
    Studentservice sService;

    @GetMapping("students")
    public List<Student> getStudents() {
        return sService.getAllStudents();
    }

    @GetMapping("students/{id}")
    public Student getById(@PathVariable long id) {
        return sService.getById(id);
    }

    @GetMapping("studentsbyalph/{alphid}")
    public Student searchByAlphId(@PathVariable String alphid) {
        return sService.searchByAlphId(alphid);
    }

    @GetMapping("studentsbyfname/{fname}")
    public List<Student> searchByFirstName(@PathVariable String fname) {
        return sService.searchByFirstName(fname);
    }

    @GetMapping("studentsbylname/{lname}")
    public List<Student> searchByLastName(@PathVariable String lname) {
        return sService.searchByLastName(lname);
    }

    @PostMapping("addstudent")
    public Student addStudent(@RequestBody Student student) {
        sService.addStudent(student);
        return student;
    }

    @DeleteMapping("students/{id}")
    public void deleteById(@PathVariable long id) {
        sService.deleteById(id);
    }

}
