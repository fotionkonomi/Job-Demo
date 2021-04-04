package de.dh.lhind.demo.jobapi.rest.controller.common;

import de.dh.lhind.demo.jobapi.rest.utils.Utils;
import de.dh.lhind.demo.jobcore.business.common.BaseClassDTO;
import de.dh.lhind.demo.jobcore.business.service.base.BaseService;
import de.dh.lhind.demo.jobcore.business.service.exception.EntityNotFoundException;
import de.dh.lhind.demo.jobcore.business.service.exception.NoElementFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URISyntaxException;
import java.util.Collection;

public abstract class CommonCrudRestController<DTO extends BaseClassDTO, ID> {
    @Autowired
    protected BaseService<DTO, ID> service;

    @GetMapping
    public ResponseEntity<Collection<DTO>> findAll() throws NoElementFoundException {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTO> findOne(@PathVariable("id") ID id) throws EntityNotFoundException {
        return ResponseEntity.ok(this.service.findById(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createObject(@RequestBody DTO dto) throws URISyntaxException {
        dto = service.save(dto);
        return ResponseEntity.created(Utils.getUriAfterPost(dto)).build();
    }

}
