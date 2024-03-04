package vch.example.spring_jpa.embedded;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ORDER_TBL")
public class Order {
    @EmbeddedId
    private OrderId id;
    @Embedded
    private Address address;

    private String orderInfo;
    private String anotherField;
}
