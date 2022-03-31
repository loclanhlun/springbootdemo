package com.example.demo.service;

import com.example.demo.request.StudentRequest;
import com.example.demo.response.StudentResponse;

import java.util.List;

public interface StudentService {

    List<StudentResponse> findAllStudent();

    void addStudent(StudentRequest student);

    void editStudent(StudentRequest student);

    void deleteStudent(Long Id);
}
