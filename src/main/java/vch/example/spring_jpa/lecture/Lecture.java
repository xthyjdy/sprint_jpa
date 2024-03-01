package vch.example.spring_jpa.lecture;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import vch.example.spring_jpa.BaseEntity;
import vch.example.spring_jpa.my_resource.MyResource;
import vch.example.spring_jpa.section.Section;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity(name = "LECTURE_TBL")
public class Lecture extends BaseEntity {
    @Column(nullable = false, length = 50)
    private String name;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    @OneToOne
    @JoinColumn(name = "resource_id")
    private MyResource resource;
}