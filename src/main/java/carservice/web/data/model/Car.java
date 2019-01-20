package carservice.web.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="car")
@NamedQueries({
    @NamedQuery(
            name = Car.FIND_ALL_CARS_BY_USER_ID,
            query = "from Car c where c.user.userId = :userId order by c.carId"
    )
})
public class Car {

    public static final String FIND_ALL_CARS_BY_USER_ID = "Car.findAllCarsByUserId";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="car_id")
    private long carId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name="nickname")
    private String nickname;

    @Column(name="vin")
    private String vin;

    @Column(name="license_plate")
    private String licensePlate;

    @NotNull
    @Column(name="make")
    private String make;

    @NotNull
    @Column(name="model")
    private String model;

    @Column(name="year")
    private Integer year;

    @Column(name="color")
    private String color;

    @Column(name="description")
    private String description;



    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Car [carId=" + carId
                + ", user=" + user
                + ", nickname=" + nickname
                + ", vin=" + vin
                + ", licensePlate=" + licensePlate
                + ", make=" + make
                + ", model=" + model
                + ", year=" + year
                + ", color=" + color
                + ", description=" + description
                + "]";
    }

}
