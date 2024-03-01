package vch.example.spring_jpa.course;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import vch.example.spring_jpa.BaseEntity;
import vch.example.spring_jpa.author.Author;
import vch.example.spring_jpa.section.Section;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity(name = "COURSE_TBL")
public class Course extends BaseEntity {
    @Column(nullable = false, length = 50)
    private String title;
    @Column(length = 200)
    private String description;

    @ManyToMany
    @JoinTable(
            name = "authors_courses",
            joinColumns = {
                    @JoinColumn(name = "course_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "author_id")
            }
    )
    private List<Author> authors;

    @OneToMany(mappedBy = "course")
    private List<Section> sections;
}
