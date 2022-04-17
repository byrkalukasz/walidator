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
    /*
Możliwe wartości pola state - aktualnie nie używane przez brak kolejki do wymiany danych
0 - Utworzona
1 - Wysłana do weryfikacji
2 - odebrana odpowiedz pozytywna
3 - Przeprocesowana
4 - Anulowana
5 - Anulowana z weryfikatora
 */
    private long id;
    private String name;
    private String surname;
    private String pesel;
    private String message;
    private long state;
}
