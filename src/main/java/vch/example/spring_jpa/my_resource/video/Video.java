package vch.example.spring_jpa.my_resource.video;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import vch.example.spring_jpa.my_resource.MyResource;

@EqualsAndHashCode(callSuper = true)//only for child
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder//builder of parent
@Entity
@DiscriminatorValue("V")
public class Video extends MyResource {
    private int length;
}
