package pl.byrka.walidator.Model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentApplication implements Serializable {
    private long id;
    private String name;
    private String surname;
    private String pesel;
}
