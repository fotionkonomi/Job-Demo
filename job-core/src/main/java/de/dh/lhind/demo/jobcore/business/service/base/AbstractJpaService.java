package de.dh.lhind.demo.jobcore.business.service.base;

import de.dh.lhind.demo.jobcore.business.common.BaseClassDTO;
import de.dh.lhind.demo.jobcore.business.service.exception.EntityNotFoundException;
import de.dh.lhind.demo.jobcore.business.service.exception.NoElementFoundException;
import de.dh.lhind.demo.jobcore.persistence.entities.common.BaseClass;
import de.dh.lhind.demo.jobcore.persistence.repository.ParentRepository;
import lombok.extern.log4j.Log4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
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
    public DTO findById(ID id) {
        Optional<ENTITY> optionalEntity = repo.findById(id);

        Optional<DTO> optionalDTO = mapOptionalEntityToDTO(optionalEntity);
        return optionalDTO.orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    public DTO save(DTO dto) {
        ENTITY mappedEntity = mapFromDTO(dto);
        mappedEntity = repo.save(mappedEntity);
        log.info(classOfEntity.getName() + " object saved successfully: " + mappedEntity);
        return mapFromEntity(mappedEntity);
    }

    @Override
    public List<DTO> findAll() {
        List<ENTITY> entityList = repo.findAll();
        List<DTO> dtoList = mapEntityListToDTO(entityList);
        if(dtoList != null) {
            return dtoList;
        }
        throw new NoElementFoundException();
    }

    @Override
    public void deleteById(ID id) {
        this.repo.deleteById(id);
    }

    protected ENTITY mapFromDTO(DTO dto) {
        return modelMapper.map(dto, classOfEntity);
    }

    protected DTO mapFromEntity(ENTITY entity) {
        return modelMapper.map(entity, classOfDTO);
    }

    private Optional<DTO> mapOptionalEntityToDTO(Optional<ENTITY> optionalEntity) {
        return Optional.ofNullable(optionalEntity.isPresent() ? mapFromEntity(optionalEntity.get()) : null);
    }

    protected List<DTO> mapEntityListToDTO(Collection<ENTITY> entityList) {
        List<DTO> dtoList = new ArrayList<>();
        entityList.forEach(entity -> dtoList.add(mapFromEntity(entity)));
        return dtoList;
    }
}
