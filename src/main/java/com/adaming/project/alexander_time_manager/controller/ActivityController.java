package com.adaming.project.alexander_time_manager.controller;

import com.adaming.project.alexander_time_manager.exception.ResourceNotFoundException;
import com.adaming.project.alexander_time_manager.model.Activity;
import com.adaming.project.alexander_time_manager.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/alexander/api/")
public class ActivityController {
    @Autowired
    ActivityRepository activityRepository;

    @GetMapping("/activities")
    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    @GetMapping("/activities/{id}")
    public ResponseEntity<Activity> getActivityById(@PathVariable(value = "id") Long activityId)
            throws ResourceNotFoundException {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + activityId));
        return ResponseEntity.ok().body(activity);
    }

    @PostMapping("/activities")
    public Activity createActivity(@Valid @RequestBody Activity activity) {
        return activityRepository.save(activity);
    }

    @PutMapping("/activities/{id}")
    public ResponseEntity<Activity> updateActivity(@PathVariable(value = "id") Long activityId,
                                           @Valid @RequestBody Activity activityDetails) throws ResourceNotFoundException {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + activityId));

        activity.setName(activityDetails.getName());
        activity.setActivityType(activityDetails.getActivityType());
        activity.setExp(activityDetails.getExp());
        activity.setLength(activityDetails.getLength());
        activity.setMemoquartz(activityDetails.getMemoquartz());
        activity.setMount(activityDetails.getMount());
        activity.setRecurency(activityDetails.getRecurency());

        final Activity updatedActivity = activityRepository.save(activity);
        return ResponseEntity.ok(updatedActivity);
    }

    @DeleteMapping("/activities/{id}")
    public Map<String, Boolean> deleteActivity(@PathVariable(value = "id") Long activityId)
            throws ResourceNotFoundException {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new ResourceNotFoundException("Activity not found for this id :: " + activityId));

        activityRepository.delete(activity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
