package com.example.demo.controller;

import com.example.demo.exception.StudentException;
import com.example.demo.request.StudentRequest;
import com.example.demo.response.ResponseModel;
import com.example.demo.response.StudentResponse;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping(value = "/list")
    public ResponseEntity<?> getAllStudent() {
        List<StudentResponse> list = studentService.findAllStudent();
        ResponseModel responseModel = new ResponseModel("200", "Successfully", list);
        return ResponseEntity.ok(responseModel);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addStudent(@RequestBody StudentRequest request) {
        ResponseModel responseModel;
        try {
            studentService.addStudent(request);
            responseModel = new ResponseModel("200", "Successfully", null);
        }catch (StudentException e) {
            responseModel = new ResponseModel("111", e.getMessage(), null);
        }
        return ResponseEntity.ok(responseModel);
    }

    @PutMapping(value = "/edit")
    public ResponseEntity<?> editStudent(@RequestBody StudentRequest request) {
        ResponseModel responseModel;
        try {
            studentService.editStudent(request);
            responseModel = new ResponseModel("200", "Successfully", null);
        }catch (StudentException e) {
            responseModel = new ResponseModel("111", e.getMessage(), null);
        }
        return ResponseEntity.ok(responseModel);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") Long id) {
        ResponseModel responseModel;
        try {
            studentService.deleteStudent(id);
            responseModel = new ResponseModel("200", "Successfully", null);
        }catch (StudentException e) {
            responseModel = new ResponseModel("111", e.getMessage(), null);
        }
        return ResponseEntity.ok(responseModel);
    }
}
