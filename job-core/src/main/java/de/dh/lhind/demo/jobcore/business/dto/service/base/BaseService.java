package de.dh.lhind.demo.jobcore.business.dto.service.base;

import de.dh.lhind.demo.jobcore.business.dto.service.exception.ConstraintException;

import java.util.List;
import java.util.Optional;

public interface BaseService<DTO, ID> {
    Optional<DTO> findById(ID id);

    DTO save(DTO dto) throws ConstraintException;

    List<DTO> findAll();
}
