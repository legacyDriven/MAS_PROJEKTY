package org.example.composition;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Building {
    //
    private final List<Room> rooms;

    public Building() {
        rooms = new ArrayList<>();
    }

    public void addRoom(@NonNull String name, int size) {
        Room room = new Room(this, name, size);
        rooms.add(room);
    }

    public void removeRoom(Room room) {
        rooms.stream()
                .filter(r -> r.equals(room))
                .findFirst()
                .ifPresent(r -> r.setBuilding(null));
        rooms.remove(room);
    }

    public void removeBuildingAndRooms() {
        // Ustawiamy referencję budynku na null dla każdego pokoju przed usunięciem
        for (Room room : rooms) {
            room.setBuilding(null);
        }
        rooms.clear();
    }
}
