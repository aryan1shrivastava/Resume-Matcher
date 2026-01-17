package com.ResumeMatch.resume_matcher.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MatchingController {
    @GetMapping("/health")
    public String health(){
        return "Resume Matcher is up and running 🚀";
    }
}


