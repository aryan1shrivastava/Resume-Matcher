package com.ResumeMatch.resume_matcher.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.ResumeMatch.resume_matcher.dto.MatchRequest;
import com.ResumeMatch.resume_matcher.dto.MatchResponse;

@RestController
@RequestMapping("/api")
public class MatchingController {
    @GetMapping("/health")
    public String health(){
        return "Resume Matcher is up and running 🚀";
    }

    @PostMapping("/match")
    public ResponseEntity<MatchResponse> matchResume(@RequestBody MatchRequest request){

        String resume = request.getResumeText();
        String jobDescription = request.getJobDescription();

        double actualScore = calculateMatchScore(resume, jobDescription);

        return ResponseEntity.ok(new MatchResponse(actualScore));
    }

    private double calculateMatchScore(String resumeText, String jdText){

        if(resumeText == null || jdText == null || jdText.isEmpty()){
            return 0.0;
        }

        String[] resumeWords = resumeText.toLowerCase().split("\\W+");
        String[] jdWords = jdText.toLowerCase().split("\\W+");

        java.util.Set<String> resumeWordSet = new java.util.HashSet<>(java.util.Arrays.asList(resumeWords));

        long matchCount = java.util.Arrays.stream(jdWords)
                .distinct() // Don't count "Java" twice if it's in the JD twice
                .filter(word -> resumeWordSet.contains(word))
                .count();

        long totalUniqueJdWords = java.util.Arrays.stream(jdWords).distinct().count();

        if (totalUniqueJdWords == 0) return 0.0;
        return ((double) matchCount / totalUniqueJdWords) * 100;

    }
}


