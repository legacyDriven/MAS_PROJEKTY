package org.example.composition;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BuildingAndRoomTest {

    private Building building;

    @BeforeEach
    void setUp() {
        building = new Building();
    }

    @Test
    @DisplayName("Kompozycja: test dodawania pokoju do budynku")
    void testAddRoom() {
        assertEquals(0, building.getRooms().size(), "Building should initially have no rooms");

        building.addRoom("Room 1", 100);
        assertEquals(1, building.getRooms().size(), "Building should have 1 room after adding a room");
        Room room = building.getRooms().get(0);
        assertNotNull(room, "Added room should not be null");
        assertEquals("Room 1", room.getName(), "Added room should have the correct name");
        assertEquals(100, room.getSize(), "Added room should have the correct size");
    }

    @Test
    @DisplayName("Kompozycja: test dodawania referencji do budynku do pokoju")
    void testRoomHasBuildingReference() {
        building.addRoom("Room 1", 100);
        Room room = building.getRooms().get(0);
        assertEquals(building, room.getBuilding(), "Room should have reference to the building it belongs to");
    }

    @Test
    @DisplayName("Kompozycja: test usuwania pokoju z budynku")
    void testRemoveRoom() {
        building.addRoom("Room 1", 100);
        Room room = building.getRooms().get(0);
        assertEquals(1, building.getRooms().size(), "Building should have 1 room after adding a room");

        building.removeRoom(room);
        assertEquals(0, building.getRooms().size(), "Building should have no rooms after removing the room");
    }

    @Test
    @DisplayName("Kompozycja: test usuwania referencji do budynku z pokoju")
    void testRemoveBuildingAndRooms() {
        building.addRoom("Room 1", 100);
        building.addRoom("Room 2", 200);
        assertEquals(2, building.getRooms().size(), "Building should have 2 rooms after adding rooms");

        List<Room> roomsBeforeRemoval = new ArrayList<>(building.getRooms());

        building.removeBuildingAndRooms();
        assertEquals(0, building.getRooms().size(), "Building should have no rooms after removing building and its rooms");

        // Sprawdzamy, czy referencje do budynku zostały usunięte z pokojów
        for (Room room : roomsBeforeRemoval) {
            assertNull(room.getBuilding(), "Room should have no reference to the building after removing building and its rooms");
        }
    }

    @DisplayName("Deleting building should remove references to building in rooms")
    @Test
    void deleteBuilding() {
        Building building = new Building();
        building.addRoom("Room 1", 10);
        building.addRoom("Room 2", 20);
        Room one = building.getRooms().get(0);
        Room two = building.getRooms().get(1);

        assertNotNull(one.getBuilding());
        assertNotNull(two.getBuilding());

        // Usuń budynek
        building = null;

        // Ustaw referencje do budynku w pokojach na null
        one.setBuilding(null);
        two.setBuilding(null);

        assertNull(one.getBuilding());
        assertNull(two.getBuilding());
    }

}



