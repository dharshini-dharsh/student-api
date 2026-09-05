package com.dharshu.student_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dharshu.student_api.dto.StudentRequest;
import com.dharshu.student_api.dto.StudentResponse;
import com.dharshu.student_api.entity.Student;
import com.dharshu.student_api.exception.ResourceNotFoundException;
import com.dharshu.student_api.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentResponse createStudent(StudentRequest request) {

        Student student = new Student();

        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setAge(request.getAge());

        Student savedStudent = studentRepository.save(student);

        return mapToResponse(savedStudent);
    }

    @Override
    public List<StudentResponse> getAllStudents() {

        return studentRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public StudentResponse getStudentById(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Student not found with id: " + id));

        return mapToResponse(student);
    }

    @Override
    public StudentResponse updateStudent(
            Long id,
            StudentRequest request) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Student not found with id: " + id));

        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setAge(request.getAge());

        Student updatedStudent = studentRepository.save(student);

        return mapToResponse(updatedStudent);
    }

    @Override
    public void deleteStudent(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Student not found with id: " + id));

        studentRepository.delete(student);
    }

    private StudentResponse mapToResponse(Student student) {

        return new StudentResponse(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getAge()
        );
    }
}