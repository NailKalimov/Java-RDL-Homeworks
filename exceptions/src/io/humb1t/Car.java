package io.humb1t;

import io.humb1t.exceptions.IllegalNumberOfDoorException;

public class Car {
    int numberOfDoors;

    public Car(int numberOfDoors) throws IllegalNumberOfDoorException {
        if (numberOfDoors == 0) {
            throw new IllegalNumberOfDoorException("Колличество дверей должно быть больше 0!");
        } else {
            this.numberOfDoors = numberOfDoors;
        }
    }
}
