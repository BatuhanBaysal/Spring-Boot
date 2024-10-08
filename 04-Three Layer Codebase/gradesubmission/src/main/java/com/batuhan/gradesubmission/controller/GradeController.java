package com.batuhan.gradesubmission.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.batuhan.gradesubmission.Grade;
import com.batuhan.gradesubmission.service.GradeService;

import jakarta.validation.Valid;

@Controller
public class GradeController {

    @Autowired
    GradeService gradeService;

    @GetMapping("/grades")
    public String Grades(Model model) {
        model.addAttribute("grades", gradeService.getGrades());
        return "grades";
    }

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
        model.addAttribute("grade", gradeService.getGradeById(id));
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(@Valid Grade grade, BindingResult result) {
        System.out.println("Has errors?: " + result.hasErrors());
        if (result.hasErrors()) return "form";
        gradeService.submitGrade(grade);
        return "redirect:/grades";
    }
}