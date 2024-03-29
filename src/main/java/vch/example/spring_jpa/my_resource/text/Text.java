package vch.example.spring_jpa.my_resource.text;

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
//@DiscriminatorValue("T")//type 1 (only with single table)
public class Text extends MyResource {
    private int content;
}
