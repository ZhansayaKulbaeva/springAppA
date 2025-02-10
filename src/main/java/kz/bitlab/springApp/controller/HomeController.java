package kz.bitlab.springApp.controller;

import kz.bitlab.springApp.db.DBManager;
import kz.bitlab.springApp.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/allStudents") // localhost:8080/allStudents
    public String allStudents(Model model) {
        model.addAttribute("allStudentList", DBManager.getStudents());
        return "students"; // название html, в templates должен быть students.html
    }

    @GetMapping("/addStudentPage") // localhost:8080/addStudentPage
    public String addStudentPage() {
        return "addStudent";  // название html, в templates должен быть addStudent.html
    }

    @PostMapping("/addStudent")
    public String addStudent(@RequestParam("name") String name,
                             @RequestParam("exam") String exam,
                             @RequestParam("surname") String surname) {
        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setExam(Integer.parseInt(exam));
        student.setMark(Integer.parseInt(exam));
        DBManager.addStudent(student);
        return "redirect:/allStudents";
    }
}
