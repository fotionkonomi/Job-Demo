package de.dh.lhind.demo.jobcore.business.service;

import de.dh.lhind.demo.jobcore.business.dto.JobDTO;
import de.dh.lhind.demo.jobcore.business.service.base.BaseService;

import java.util.Collection;

public interface JobService extends BaseService<JobDTO, Long> {
    Collection<JobDTO> filterByDescription(String query, Long userId);

    Collection<JobDTO> find10LatestJobs(Long userId);

    JobDTO saveUser(Long jobId, Long userId);

    Collection<JobDTO> getJobsAppliedByUser(Long userId);
}
