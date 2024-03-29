package vch.example.spring_jpa.my_resource.video;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;
import vch.example.spring_jpa.my_resource.MyResource;

@EqualsAndHashCode(callSuper = true)//only for child
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder//builder of parent
@Entity
@PrimaryKeyJoinColumn(name = "video_id")//type 2;
//@DiscriminatorValue("V")//type 1 (only with single table)
//@Polymorphism(type = PolymorphismType.EXPLICIT)//explicit current class while `myResource` query
public class Video extends MyResource {
    private int length;
}
