package com.adaming.project.alexander_time_manager.controller;

import com.adaming.project.alexander_time_manager.exception.ResourceNotFoundException;
import com.adaming.project.alexander_time_manager.model.Mount;
import com.adaming.project.alexander_time_manager.repository.MountRepository;
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
public class MountController {
    @Autowired
    MountRepository mountRepository;

    @GetMapping("/mounts")
    public List<Mount> getAllMounts() {
        return mountRepository.findAll();
    }
    @GetMapping("/mounts/{id}")
    public ResponseEntity<Mount> getMountById(@PathVariable(value = "id") Long mountId)
            throws ResourceNotFoundException {
        Mount mount = mountRepository.findById(mountId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + mountId));
        return ResponseEntity.ok().body(mount);
    }

    @PostMapping("/mounts")
    public Mount createMount(@Valid @RequestBody Mount mount) {
        return mountRepository.save(mount);
    }

    @PutMapping("/mounts/{id}")
    public ResponseEntity<Mount> updateMount(@PathVariable(value = "id") Long mountId,
                                           @Valid @RequestBody Mount mountDetails) throws ResourceNotFoundException {
        Mount mount = mountRepository.findById(mountId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + mountId));

        mount.setAnimal(mountDetails.getAnimal());
        mount.setTrial(mountDetails.getTrial());
        final Mount updatedMount = mountRepository.save(mount);
        return ResponseEntity.ok(updatedMount);
    }

    @DeleteMapping("/mounts/{id}")
    public Map<String, Boolean> deleteMount(@PathVariable(value = "id") Long mountId)
            throws ResourceNotFoundException {
        Mount mount = mountRepository.findById(mountId)
                .orElseThrow(() -> new ResourceNotFoundException("Mount not found for this id :: " + mountId));

        mountRepository.delete(mount);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
