package de.dh.lhind.demo.jobcore.persistence.repository;

import de.dh.lhind.demo.jobcore.persistence.entities.Company;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends ParentRepository<Company, Long> {
}
