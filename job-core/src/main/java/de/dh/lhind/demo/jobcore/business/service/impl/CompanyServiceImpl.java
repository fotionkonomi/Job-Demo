package de.dh.lhind.demo.jobcore.business.service.impl;

import de.dh.lhind.demo.jobcore.business.dto.CompanyDTO;
import de.dh.lhind.demo.jobcore.business.service.CompanyService;
import de.dh.lhind.demo.jobcore.business.service.base.AbstractJpaService;
import de.dh.lhind.demo.jobcore.persistence.entities.Company;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl extends AbstractJpaService<CompanyDTO, Company, Long> implements CompanyService {
    public CompanyServiceImpl() {
        super(Company.class, CompanyDTO.class);
    }

}
