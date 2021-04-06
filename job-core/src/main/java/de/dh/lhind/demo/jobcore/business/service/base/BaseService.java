package de.dh.lhind.demo.jobcore.business.service.base;

import de.dh.lhind.demo.jobcore.business.service.exception.EntityNotFoundException;
import de.dh.lhind.demo.jobcore.business.service.exception.NoElementFoundException;

import java.util.List;


public interface BaseService<DTO, ID> {
    DTO findById(ID id) throws EntityNotFoundException;

    DTO save(DTO dto);

    List<DTO> findAll() throws NoElementFoundException;

    void deleteById(ID id);
}
