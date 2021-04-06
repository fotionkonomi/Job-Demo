package de.dh.lhind.demo.jobcore.persistence.entities.common;

import de.dh.lhind.demo.jobcore.persistence.entities.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class UserDependentEntity extends BaseClass {
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "created_by", updatable = false)
    private User createdBy;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "updated_by")
    private User updatedBy;

}
