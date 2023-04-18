package hiber.model;
import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "car")
public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", series=" + series +
                '}';
    }
    @Column(name = "model")
    private String model;
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getSeries() {
        return series;
    }
    public void setSeries(int series) {
        this.series = series;
    }
    @Column(name = "series")
    private int series;
    public Car() {
    }
    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    @OneToOne(mappedBy = "usercar", cascade = CascadeType.ALL)
    private User user;
}

