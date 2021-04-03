package de.dh.lhind.demo.jobcore.persistence.entities.common;

import de.dh.lhind.demo.jobcore.persistence.entities.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class UserDependentEntity extends BaseClass {
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "created_by")
    private User createdBy;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "updated_by")
    private User updatedBy;
}
