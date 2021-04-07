package de.dh.lhind.demo.jobcore.persistence.repository;

import de.dh.lhind.demo.jobcore.persistence.entities.Job;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface JobRepository extends ParentRepository<Job, Long> {

    @Query(nativeQuery = true, value = "SELECT * From job left join user_jobs on job.id = user_jobs.id_job where ((user_jobs.id_user is null or id_user <> :userId) and deleted = false and description LIKE CONCAT('%', CONCAT(:description, '%')))")
    List<Job> findByDescriptionContaining(@Param("description") String description, @Param("userId") Long userId);

    @Query(nativeQuery = true, value = "SELECT * From job left join user_jobs on job.id = user_jobs.id_job where ((user_jobs.id_user is null or id_user <> :userId) and deleted = false) order by id LIMIT 10")
    List<Job> findTop10ByOrderByIdDesc(@Param("userId") Long userId);


}
