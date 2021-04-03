package de.dh.lhind.demo.jobcore.persistence.repository;

import de.dh.lhind.demo.jobcore.persistence.entities.Job;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends ParentRepository<Job, Long> {
}
