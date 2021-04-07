package de.dh.lhind.demo.jobcore.business.service.impl;

import de.dh.lhind.demo.jobcore.business.dto.JobDTO;
import de.dh.lhind.demo.jobcore.business.service.JobService;
import de.dh.lhind.demo.jobcore.business.service.base.AbstractJpaService;
import de.dh.lhind.demo.jobcore.business.service.exception.EntityNotFoundException;
import de.dh.lhind.demo.jobcore.persistence.entities.Job;
import de.dh.lhind.demo.jobcore.persistence.entities.User;
import de.dh.lhind.demo.jobcore.persistence.repository.JobRepository;
import de.dh.lhind.demo.jobcore.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@Service
public class JobServiceImpl extends AbstractJpaService<JobDTO, Job, Long> implements JobService {
    @Autowired
    private UserRepository userRepository;

    public JobServiceImpl() {
        super(Job.class, JobDTO.class);
    }

    @Override
    public Collection<JobDTO> filterByDescription(String query, Long userId) {
        return mapEntityListToDTO(((JobRepository)repo).findByDescriptionContaining(query, userId));
    }

    @Override
    public Collection<JobDTO> find10LatestJobs(Long userId) {
        return mapEntityListToDTO(((JobRepository)repo).findTop10ByOrderByIdDesc(userId));
    }

    @Override
    public JobDTO saveUser(Long jobId, Long userId) {
        Optional<Job> optionalJob = this.repo.findById(jobId);
        Job job = null;
        if(optionalJob.isPresent()) {
            job = optionalJob.get();
        } else {
            throw new EntityNotFoundException();
        }

        Optional<User> optionalUser = this.userRepository.findById(userId);
        User user = null;
        if(optionalUser.isPresent()) {
            user = optionalUser.get();
        } else {
            throw new EntityNotFoundException();
        }
        job.addUser(user);
        Job savedJob = repo.save(job);
        return mapFromEntity(savedJob);
    }

    @Override
    public Collection<JobDTO> getJobsAppliedByUser(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        User user = null;
        if(userOptional.isPresent()) {
            user = userOptional.get();
        } else {
            throw new EntityNotFoundException();
        }
        Set<Job> jobs = user.getJobsApplied();
        return mapEntityListToDTO(jobs);
    }


}
