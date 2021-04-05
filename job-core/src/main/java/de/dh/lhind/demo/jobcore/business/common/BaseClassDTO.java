package de.dh.lhind.demo.jobcore.business.common;

import lombok.Data;

import java.util.Date;

@Data
public abstract class BaseClassDTO {
    private Long id;
    private Date createdAt;
    private Date updatedAt;
    private Boolean deleted;

}
