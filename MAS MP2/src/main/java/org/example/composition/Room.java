package org.example.composition;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;



@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@Getter
@Setter
public class Room {
    private int roomNumber;
    private int capacity;
    @NonFinal
    @Setter
    private Building building;

    public Room(int roomNumber, int capacity, Building building) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.building = building;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Building getBuilding() {
        return building;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + roomNumber;
        result = prime * result + capacity;
        result = prime * result + 12345; // a constant value to ignore the building field
        return result;
    }
}
