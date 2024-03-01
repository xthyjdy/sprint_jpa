package vch.example.spring_jpa.my_resource;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import vch.example.spring_jpa.lecture.Lecture;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity(name = "RESOURCE_TBL")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "resource_type")
public class MyResource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 50)
    private String name;
    private int size;
    private String url;

    @OneToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;
}