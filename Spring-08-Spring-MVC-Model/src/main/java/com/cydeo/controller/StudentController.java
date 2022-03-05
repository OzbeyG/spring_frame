package com.cydeo.controller;

import com.cydeo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController {


    @RequestMapping("/welcome")
    public String  homePage(Model model) {
        model.addAttribute("name","Cydeo");
        model.addAttribute("course","MVC");


        String subject = "Collections";
        model.addAttribute("subject",subject);

        int randomNumber = new Random().nextInt(10);
        model.addAttribute("random",randomNumber);

        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(Arrays.asList(1,3,5,6,7,8,0));
        model.addAttribute("numbers",numbers);


        Student student = new Student(3,"Mike","Smith");

        model.addAttribute("students",student);


        return "student/welcome";//model not having html extension since dynamic

    }
}
