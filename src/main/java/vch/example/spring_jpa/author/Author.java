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
@NamedQueries({
        @NamedQuery(
                name = "Author.findByNamedQuery",
                query = "SELECT a FROM AUTHOR_TBL a where a.firstName = :firstName"
        ),
        @NamedQuery(
                name = "Author.updateByNamedQuery",
                query = "UPDATE AUTHOR_TBL a SET a.firstName = :newName WHERE a.id = 1"
        ),
        @NamedQuery(
                name = "findUsersByFirstNameContaining",
                query = "SELECT a FROM AUTHOR_TBL a WHERE a.firstName LIKE :searchString"
        )
})
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
