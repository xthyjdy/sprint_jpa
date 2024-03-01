package vch.example.spring_jpa.section;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import vch.example.spring_jpa.BaseEntity;
import vch.example.spring_jpa.course.Course;
import vch.example.spring_jpa.lecture.Lecture;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity(name = "SECTION_TBL")
public class Section extends BaseEntity {
    @Column(nullable = false, length = 50)
    private String name;
    private short sectionOrder;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "section")
    private List<Lecture> lectures;
}
