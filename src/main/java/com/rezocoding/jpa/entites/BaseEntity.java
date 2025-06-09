package com.rezocoding.jpa.entites;

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

    @Column(name = "created_at", updatable = false,nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at",insertable = false)
    private LocalDateTime updatedAt;
}
