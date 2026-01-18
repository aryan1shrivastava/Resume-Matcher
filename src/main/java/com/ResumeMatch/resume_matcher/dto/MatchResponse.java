package com.ResumeMatch.resume_matcher.dto;

public class MatchResponse {
    private double matchPercentage;

    public MatchResponse( double matchPercentage ) {{
    this.matchPercentage = matchPercentage;}
    }

    public double getMatchPercentage(){
        return matchPercentage;
    }

    public void setMatchPercentage( double matchPercentage ){
        this.matchPercentage = matchPercentage;
    }
}
