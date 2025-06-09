package com.rezocoding.jpa.entites;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Resource extends BaseEntity{

    private String name;

    private int size;

    private String url;
}
