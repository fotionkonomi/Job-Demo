package de.dh.lhind.demo.jobcore.business.dto.service.base;

import de.dh.lhind.demo.jobcore.business.dto.common.BaseClassDTO;
import de.dh.lhind.demo.jobcore.business.dto.service.exception.ConstraintException;
import de.dh.lhind.demo.jobcore.persistence.entities.common.BaseClass;
import de.dh.lhind.demo.jobcore.persistence.repository.ParentRepository;
import lombok.extern.log4j.Log4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j
@Transactional
public abstract class AbstractJpaService<DTO extends BaseClassDTO, ENTITY extends BaseClass, ID>
    implements BaseService<DTO, ID> {

    @Autowired
    protected ParentRepository<ENTITY, ID> repo;

    @Autowired
    protected ModelMapper modelMapper;

    protected Class<ENTITY> classOfEntity;
    protected Class<DTO> classOfDTO;

    public AbstractJpaService(Class<ENTITY> classOfEntity, Class<DTO> classOfDTO) {
        this.classOfEntity = classOfEntity;
        this.classOfDTO = classOfDTO;
    }

    @Override
    public Optional<DTO> findById(ID id) {
        Optional<ENTITY> optionalEntity = repo.findById(id);

        return mapOptionalEntityToDTO(optionalEntity);
    }

    @Override
    public DTO save(DTO dto) throws ConstraintException {
        try {
            ENTITY mappedEntity = mapFromDTO(dto);
            mappedEntity = repo.save(mappedEntity);
            log.info(classOfEntity.getName() + " object saved successfully: " + mappedEntity);
            return mapFromEntity(mappedEntity);
        } catch (DataIntegrityViolationException e) {
            log.error(classOfEntity.getName() + " object could not be saved, exception thrown: " + e);
            throw new ConstraintException(e.getMessage(), e);
        }
    }

    @Override
    public List<DTO> findAll() {
        return mapEntityListToDTO(repo.findAll());
    }

    private ENTITY mapFromDTO(DTO dto) {
        return modelMapper.map(dto, classOfEntity);
    }

    protected DTO mapFromEntity(ENTITY entity) {
        return modelMapper.map(entity, classOfDTO);
    }

    private Optional<DTO> mapOptionalEntityToDTO(Optional<ENTITY> optionalEntity) {
        return Optional.ofNullable(optionalEntity.isPresent() ? mapFromEntity(optionalEntity.get()) : null);
    }

    private List<DTO> mapEntityListToDTO(List<ENTITY> entityList) {
        List<DTO> dtoList = new ArrayList<>();
        entityList.forEach(entity -> dtoList.add(mapFromEntity(entity)));
        return dtoList;
    }
}
