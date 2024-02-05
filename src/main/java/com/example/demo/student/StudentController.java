package com.example.demo.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //annotation
@RequestMapping(path = "api/v1/student") // http://localhost:8080/api/v1/student
public class StudentController {

    private final StudentService studentService;

    @Autowired // auto connect with bean
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

//	@GetMapping //Rest endpoint - web
//	public String isMe() {
//		return "I'm Liang";
//	}

//	@GetMapping //Rest endpoint - json
//	public List<String> isMe1() {
//		return List.of("Liang", "fat_liang0");
//	}

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }
}
