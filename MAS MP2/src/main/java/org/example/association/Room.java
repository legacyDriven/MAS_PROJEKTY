package org.example.association;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Room {
    Building building;
    String name;
    int size;

    // Asocjacja: każda Sala należy do jednego konkretnego Budynku
    // Prywatny konstruktor, nie można go wywołać z zewnątrz klasy Room
    private Room(Building building, String name, int size) {
        this.building = building;
        this.name = name;
        this.size = size;
    }

    // Statyczna, publiczna metoda tworząca obiekt klasy Room
    public static Room createRoom(Building building, String name, int size) {
        Room room = new Room(building, name, size);
        building.addRoom(room);
        return room;
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
