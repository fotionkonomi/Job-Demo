package de.dh.lhind.demo.jobapi.rest.controller;

import de.dh.lhind.demo.jobapi.rest.controller.common.CommonCrudRestController;
import de.dh.lhind.demo.jobapi.security.userdetails.MyUserDetails;
import de.dh.lhind.demo.jobcore.business.dto.CompanyDTO;
import de.dh.lhind.demo.jobcore.business.dto.JobDTO;
import de.dh.lhind.demo.jobcore.business.dto.UserDTO;
import de.dh.lhind.demo.jobcore.business.service.JobService;
import de.dh.lhind.demo.jobcore.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@RequestMapping("/job")
public class JobController extends CommonCrudRestController<JobDTO, Long> {
    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<Void> createObject(@RequestBody JobDTO dto) throws URISyntaxException {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDTO userDTO = userService.findByEmail(userDetails.getEmail());
        dto.setCreatedBy(userDTO);
        dto.setUpdatedBy(userDTO);
        return super.createObject(dto);
    }

    @Override
    public ResponseEntity<Void> updateObject(@RequestBody JobDTO dto) throws URISyntaxException {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDTO userDTO = userService.findByEmail(userDetails.getEmail());
        dto.setUpdatedBy(userDTO);
        return super.updateObject(dto);
    }

    @GetMapping("/search")
    public ResponseEntity<Collection<JobDTO>> filteredJobs(@RequestParam("query") String query) {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(((JobService)service).filterByDescription(query, userDetails.getId()));
    }

    @GetMapping("/topTen")
    public ResponseEntity<Collection<JobDTO>> topTenJobs() {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(((JobService)service).find10LatestJobs(userDetails.getId()));
    }

    @PutMapping("/apply")
    public ResponseEntity<JobDTO> userApplication(@RequestBody Long jobId) {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(((JobService) service).saveUser(jobId, userDetails.getId()));
    }

    @GetMapping("/myApplications")
    public ResponseEntity<Collection<JobDTO>> getUserApplications() {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(((JobService) service).getJobsAppliedByUser(userDetails.getId()));
    }
}
