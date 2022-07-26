package hiber.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "cars")
public class Car {
    @Id
    @ToString.Exclude
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    @ToString.Exclude
    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Car() {

    }
}
