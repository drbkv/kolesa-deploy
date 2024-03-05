package ru.job4j.cars.store;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class BodyTypeStore {
    private final List<String> bodyTypes;

    public BodyTypeStore() {
        this.bodyTypes = Arrays.asList(
                "Седан", "Хэтчбэк", "Универсал", "Пикап", "Кроссовер"
        );
    }

    public List<String> getBodyTypes() {
        return bodyTypes;
    }
}
