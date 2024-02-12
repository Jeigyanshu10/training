package com.anshu.jobapp.controllers;

import com.anshu.jobapp.entities.JobEntity;
import com.anshu.jobapp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
   private JobService jobService;

    @GetMapping
    public ResponseEntity<List<JobEntity>> findAll(){
        return new ResponseEntity<>(jobService.FindAll(),HttpStatus.OK) ;
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody JobEntity jobEntity){
        jobService.createJob(jobEntity);
        return new ResponseEntity<>("Job added successfully",HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobEntity> getJobById(@PathVariable String id){
        Long longId = Long.parseLong(id);
        return new ResponseEntity<>(jobService.findJobById(longId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeJobById(@PathVariable String id){
        Long longId = Long.parseLong(id);
         if(jobService.removeJobById(longId)){
             return new ResponseEntity<>("Job Removed sucessfully",HttpStatus.OK);
         }
        return new ResponseEntity<>("Unable to find Job, please try again with a valid job Id",HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobEntity> updateJob(@PathVariable String id, @RequestBody JobEntity jobEntity){
        Long longId = Long.parseLong(id);
        return new ResponseEntity<>(jobService.updatejob(longId, jobEntity),HttpStatus.OK);
    }
}
