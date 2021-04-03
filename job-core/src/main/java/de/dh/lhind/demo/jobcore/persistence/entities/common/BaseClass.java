package de.dh.lhind.demo.jobcore.persistence.entities.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Data
public abstract class BaseClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, columnDefinition = "DATETIME")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, columnDefinition = "DATETIME")
    private Date updatedAt;

    @Column(nullable = false, name = "deleted")
    private Boolean deleted;

    @PrePersist
    private void prePersist() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
        this.deleted = false;
    }

    @PreUpdate
    private void preUpdate() {
        this.updatedAt = new Date();
        if (this.deleted == null) {
            this.deleted = false;
        }
    }

}
