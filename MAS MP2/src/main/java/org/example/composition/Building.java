package org.example.composition;

import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
public class Building {
    private List<Room> rooms;

    public Building() {
        this.rooms = new ArrayList<>();
    }

    public Room createRoom(int roomNumber, int capacity) {
        Room room = new Room(roomNumber, capacity, this);
        rooms.add(room);
        return room;
    }

    public void removeRoom(Room room) {
        room.setBuilding(null); // remove building reference from the room
        rooms.remove(room);
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
