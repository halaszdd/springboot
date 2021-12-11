package hu.unideb.inf.webfejlbeadando.ingamehero;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor   // Csinál argumentum nélküli constructort
@AllArgsConstructor  // Csinál az összes argumentummal constructort
@Getter             //Fordítás időben legenerálja őket automatikusan
@Setter             //Fordítás időben legenerálja őket automatikusan
@ToString
@Entity
@Table
public class InGameHero {

    @Id
    @SequenceGenerator(
            name = "ingamehero_sequence",
            sequenceName = "ingamehero_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ingamehero_sequence"
    )
    private Long id;

    private String name;
    private Integer rarity;
    private String sex;
    private String vision;
    private String constellation;

    public InGameHero(String name, Integer rarity, String sex, String vision, String constellation) {
        this.name = name;
        this.rarity = rarity;
        this.sex = sex;
        this.vision = vision;
        this.constellation = constellation;
    }
}
