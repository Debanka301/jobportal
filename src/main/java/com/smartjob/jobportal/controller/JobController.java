package com.smartjob.jobportal.controller;


import com.smartjob.jobportal.model.Job;
import com.smartjob.jobportal.service.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")  // Only Admins allowed
    public ResponseEntity<Job> addJob(@RequestBody Job job) {
        Job createdJob = jobService.addJob(job);
        return ResponseEntity.ok(createdJob);
    }

    @GetMapping("/getall")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<List<Job>> getAllJobs(){
        return ResponseEntity.ok(jobService.getAllJobs());
    }
}
