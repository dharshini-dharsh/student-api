package com.dharshu.student_api.service;

import java.util.List;

import com.dharshu.student_api.dto.StudentRequest;
import com.dharshu.student_api.dto.StudentResponse;

public interface StudentService {

    StudentResponse createStudent(StudentRequest request);

    List<StudentResponse> getAllStudents();

    StudentResponse getStudentById(Long id);

    StudentResponse updateStudent(Long id, StudentRequest request);

    void deleteStudent(Long id);
}