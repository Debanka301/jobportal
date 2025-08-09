package com.smartjob.jobportal.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;

    private String title;

    private String company;

    private String description;

    private List<String> skillsRequired;

    private String location;

    // Constructors
    public Job() {
    }

    public Job(String title, String company, String description, List<String> skillsRequired, String location) {
        this.title = title;
        this.company = company;
        this.description = description;
        this.skillsRequired = skillsRequired;
        this.location = location;
    }

    // Getters and setters

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getSkillsRequired() {
        return skillsRequired;
    }

    public void setSkillsRequired(List<String> skillsRequired) {
        this.skillsRequired = skillsRequired;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

