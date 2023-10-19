package com.example.coolapp;
import com.example.coolapp.dto.ApiResponse;
import com.example.coolapp.enums.Status;
import com.example.coolapp.models.Student;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.example.coolapp.exceptions.StudentNotFoundException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("/api")
public class StudentController {

    private List<Student> allStudents;

    @PostConstruct
    public void loadData () {
        allStudents = new ArrayList<>();
        allStudents.add(new Student ("Lauretta", "Okolie"));
        allStudents.add(new Student("Jamiu", "Muritala"));
        allStudents.add(new Student("Gabriel", "Solomon"));
        allStudents.add(new Student("Micheal", "Akande"));
    }

    @GetMapping("/students")
    public ApiResponse<List<Student>> getAllStudents(){
        return new ApiResponse<>("Students data fetched successfully", Status.SUCCESS,allStudents);
    }

    @GetMapping("/students/{id}")
    public ApiResponse<Student> getStudent (@PathVariable Integer id) {
        if(id > allStudents.size() || id < 0){
            throw new StudentNotFoundException("student with id not found "+ id);
        }
        return new ApiResponse<>("student data fetched successfully", Status.SUCCESS,allStudents.get(id));

    }

    @PostMapping("/students")
    public ApiResponse<Student> addStudent (@Valid @RequestBody  Student student){
        allStudents.add(student);
        return new ApiResponse<>("Student added successfully",Status.SUCCESS,null);


    }


    @PutMapping("/students/{id}")
    public ApiResponse<Student> updateStudent (@PathVariable Integer id, @Valid @RequestBody Student student) {
        Student updatedStudent = allStudents.get(id);
        updatedStudent.setFirstName(student.getFirstName());
        updatedStudent.setLastName(student.getLastName());
        return new ApiResponse<>("Updated student data successfully",Status.SUCCESS,allStudents.get(id));

    }


    @DeleteMapping("/students/{id}")
    public ApiResponse<Student> deleteStudent (@PathVariable Integer id){
        Student deleteStudent = allStudents.get(id);
        allStudents.remove(2);
        return new ApiResponse<>("Delete successfully",Status.SUCCESS,null);
    }










}
