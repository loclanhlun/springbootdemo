package com.example.demo.service.impl;

import com.example.demo.entities.Student;
import com.example.demo.exception.StudentException;
import com.example.demo.repository.StudentRepository;
import com.example.demo.request.StudentRequest;
import com.example.demo.response.StudentResponse;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public List<StudentResponse> findAllStudent() {
        List<StudentResponse> listResult = new ArrayList<>();
        List<Student> students = studentRepository.findAll();
        for (Student student: students) {
            StudentResponse studentResponse = getStudent(student);
            listResult.add(studentResponse);
        }
        return listResult;
    }

    @Override
    public void addStudent(StudentRequest student) {
        Student students = studentRepository.findStudentByEmail(student.getEmail());
        if(!StringUtils.isEmpty(students)){
            throw new StudentException("Student is exists");
        }
        studentRepository.save(setStudent(student));
    }

    @Override
    public void editStudent(StudentRequest student) {
        Student students = studentRepository.findById(student.getId()).orElse(null);
        if(StringUtils.isEmpty(students)) {
            throw new StudentException(HttpStatus.NOT_FOUND, "Student is not found!");
        }
        studentRepository.save(setStudent(student));
    }

    @Override
    public void deleteStudent(Long Id) {
        studentRepository.deleteById(Id);
    }

    private StudentResponse getStudent(Student students) {
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setFirstName(students.getFirstName());
        studentResponse.setMiddleName(students.getMiddleName());
        studentResponse.setLastName(students.getLastName());
        studentResponse.setAge(students.getAge());
        studentResponse.setAddress(students.getAddress());
        studentResponse.setEmail(students.getEmail());
        studentResponse.setGender(students.getGender());
        return studentResponse;
    }

    private Student setStudent(StudentRequest student) {
        Student students = new Student();
        students.setFirstName(student.getFirstName());
        students.setMiddleName(student.getMiddleName());
        students.setLastName(student.getLastName());
        students.setAge(student.getAge());
        students.setAddress(student.getAddress());
        students.setEmail(student.getEmail());
        students.setGender(student.getGender());
        return students;
    }
}
