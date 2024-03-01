package vch.example.spring_jpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;
    @Column(insertable = false)
    private LocalDateTime lastModifiedAt;
    @Column(updatable = false, nullable = false)
    private Long createdBy;
    @Column(insertable = false)
    private Long lastModifiedBy;
}
