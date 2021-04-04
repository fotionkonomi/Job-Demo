package de.dh.lhind.demo.jobcore.business.dto.service.impl;

import de.dh.lhind.demo.jobcore.business.dto.CompanyDTO;
import de.dh.lhind.demo.jobcore.business.dto.service.base.AbstractJpaService;
import de.dh.lhind.demo.jobcore.persistence.entities.Company;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl extends AbstractJpaService<CompanyDTO, Company, Long> {
    public CompanyServiceImpl() {
        super(Company.class, CompanyDTO.class);
    }
}
