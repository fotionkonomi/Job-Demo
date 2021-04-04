package de.dh.lhind.demo.jobcore.business.dto.service.impl;

import de.dh.lhind.demo.jobcore.business.dto.JobDTO;
import de.dh.lhind.demo.jobcore.business.dto.service.JobService;
import de.dh.lhind.demo.jobcore.business.dto.service.base.AbstractJpaService;
import de.dh.lhind.demo.jobcore.persistence.entities.Job;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl extends AbstractJpaService<JobDTO, Job, Long> implements JobService {
    public JobServiceImpl() {
        super(Job.class, JobDTO.class);
    }
}
