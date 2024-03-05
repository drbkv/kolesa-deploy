package ru.job4j.cars.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bodyType;

    @Temporal(TemporalType.DATE)
    private Date created = new Date();

    @ManyToOne
    @JoinColumn(name = "carmark_id")
    private CarMark carMark;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Photo> photos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "engine_id", foreignKey = @ForeignKey(name = "ENGINE_ID_FK"))
    private Engine engine;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "history_owner", joinColumns = {
                @JoinColumn(name = "driver_id", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                @JoinColumn(name = "car_id", nullable = false, updatable = false)
            }
    )
    private Set<Driver> drivers = new HashSet<>();

    public Car() {
    }

    public Car(int id, String bodyType, CarMark carMark, Engine engine) {
        this.id = id;
        this.bodyType = bodyType;
        this.carMark = carMark;
        this.engine = engine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public CarMark getCarMark() {
        return carMark;
    }

    public void setCarMark(CarMark carMark) {
        this.carMark = carMark;
    }

    @Override
    public String toString() {
        return "Car{"
                + "id=" + id
                + ", bodyType='" + bodyType + '\''
                + ", created=" + created
                + ", carMark=" + carMark
                + ", engine=" + engine
                + ", photos=" + photos.size()
                + '}';
    }
}
