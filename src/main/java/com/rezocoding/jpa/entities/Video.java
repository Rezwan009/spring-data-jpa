package com.rezocoding.jpa.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
//@PrimaryKeyJoinColumn(name = "video_id")
//@DiscriminatorValue(value = "V")
@Polymorphism(type = PolymorphismType.EXPLICIT)
public class Video extends Resource{

    private int length;
}
