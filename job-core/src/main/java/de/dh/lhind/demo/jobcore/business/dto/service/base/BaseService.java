package de.dh.lhind.demo.jobcore.business.dto.service.base;

import de.dh.lhind.demo.jobcore.business.dto.service.exception.ConstraintException;

import java.util.List;

public interface BaseService<DTO, ID> {
    DTO findById(ID id);

    DTO save(DTO dto) throws ConstraintException;

    List<DTO> findAll();
}
