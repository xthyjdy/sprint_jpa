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
@Inheritance(strategy = InheritanceType.JOINED)//type 2
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)//type 1
//@DiscriminatorColumn(name = "resource_type")//type 1 (only with single table)
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