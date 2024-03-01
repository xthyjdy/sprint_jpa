package vch.example.spring_jpa.author;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import vch.example.spring_jpa.BaseEntity;
import vch.example.spring_jpa.course.Course;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity(name = "AUTHOR_TBL")
public class Author extends BaseEntity {
    @Column(name = "f_name", length = 150)
    private String firstName;
    @Column(name = "l_name", length = 150)
    private String lastName;
    @Column(unique = false, nullable = false, length = 30)
    private String email;
    private Short age;
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;
    @Column(insertable = false)
    private LocalDateTime lastModifiedAt;

    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;
}
