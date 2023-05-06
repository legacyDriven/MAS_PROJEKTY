package org.example.association;

public class Main {

    public static void main(String[] args) {
        Building building = new Building();
        Room room1 = Room.createRoom(building, "Conference Room", 50);
        Room room2 = Room.createRoom(building, "Office", 20);

        System.out.println("Building has " + building.getRooms().size() + " rooms"); // toString() is not called
        System.out.println("Building has " + building.getRooms() + " rooms"); // toString() is called implicitly
        System.out.println(building);
    }
}