package com.adaming.project.alexander_time_manager.controller;

import com.adaming.project.alexander_time_manager.exception.ResourceNotFoundException;
import com.adaming.project.alexander_time_manager.model.Job;
import com.adaming.project.alexander_time_manager.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:8181")
@RequestMapping("/alexander/api/")
public class JobController {
    @Autowired
    JobRepository jobRepository;

    @GetMapping("/jobs")
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable(value = "id") Long jobId)
            throws ResourceNotFoundException {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + jobId));
        return ResponseEntity.ok().body(job);
    }

    @PostMapping("/jobs")
    public Job createJob(@Valid @RequestBody Job job) {
        return jobRepository.save(job);
    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable(value = "id") Long jobId,
                                           @Valid @RequestBody Job jobDetails) throws ResourceNotFoundException {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + jobId));

        job.setName(jobDetails.getName());
        job.setLevel(jobDetails.getLevel());
        job.setType(jobDetails.getType());

        final Job updatedJob = jobRepository.save(job);
        return ResponseEntity.ok(updatedJob);
    }

    @DeleteMapping("/jobs/{id}")
    public Map<String, Boolean> deleteJob(@PathVariable(value = "id") Long jobId)
            throws ResourceNotFoundException {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new ResourceNotFoundException("Job not found for this id :: " + jobId));

        jobRepository.delete(job);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
