package com.portfolio.leetcode;


public class LeetCodeApiResponse {
    public String status;
    public String message;
    public int totalSolved;
    public int easySolved;
    public int mediumSolved;
    public int hardSolved;

    public int totalEasy;
    public int totalMedium;
    public int totalHard;

    public int ranking;


    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public int getTotalSolved() { return totalSolved; }
    public void setTotalSolved(int totalSolved) { this.totalSolved = totalSolved; }
    public int getEasySolved() { return easySolved; }
    public void setEasySolved(int easySolved) { this.easySolved = easySolved; }
    public int getMediumSolved() { return mediumSolved; }
    public void setMediumSolved(int mediumSolved) { this.mediumSolved = mediumSolved; }
    public int getHardSolved() { return hardSolved; }
    public void setHardSolved(int hardSolved) { this.hardSolved = hardSolved; }
    public int getRanking() { return ranking; }
    public void setRanking(int ranking) { this.ranking = ranking; }

    public int getTotalEasy() {
        return totalEasy;
    }

    public void setTotalEasy(int totalEasy) {
        this.totalEasy = totalEasy;
    }

    public int getTotalMedium() {
        return totalMedium;
    }

    public void setTotalMedium(int totalMedium) {
        this.totalMedium = totalMedium;
    }

    public int getTotalHard() {
        return totalHard;
    }

    public void setTotalHard(int totalHard) {
        this.totalHard = totalHard;
    }
}