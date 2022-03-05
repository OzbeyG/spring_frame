package com.cydeo.controller;

import com.cydeo.enums.Gender;
import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MentorController {



    @RequestMapping("/mentor")
    public String mentor(Model model) {

        List<Mentor> mentorList = new ArrayList<>();
         mentorList.add(new Mentor("Sara","Morning",33, Gender.FEMALE));
         mentorList.add(new Mentor("Arin","Smith",31, Gender.MALE));
         mentorList.add(new Mentor("Adar","Revers",31, Gender.MALE));

            model.addAttribute("mentors",mentorList);

        return "mentor/mentor";
    }
}
