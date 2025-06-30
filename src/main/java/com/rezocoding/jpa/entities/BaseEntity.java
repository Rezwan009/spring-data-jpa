package com.rezocoding.jpa.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
@NoArgsConstructor
@SuperBuilder
public class BaseEntity {
    @Id
    @GeneratedValue
            /*(strategy = GenerationType.SEQUENCE, generator = "author_id_gen")
    @SequenceGenerator(
            name = "author_id_gen",
            sequenceName = "author_id_gen",
            allocationSize = 1
    )*/
    private Integer id;

    @Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean status;

    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false)
    private LocalDateTime updatedAt;

    @Column(name = "created_by",updatable = false, nullable = false)
    private String createdBy;

    @Column(name = "updated_by", insertable = false)
    private String updatedBy;
}
