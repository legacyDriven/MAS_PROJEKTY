package org.example.association;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Building {
    List<Room> rooms;

    // Asocjacja: 1 Budynek może mieć wiele Sal
    public Building() {
        rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    @Override
    public String toString() {
        return "Building{" +
                "rooms=" + rooms.stream().map(Room::getName).toList() +
                '}';
    }
}
