package org.example.association;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BuildingTest {

    @Test
    @DisplayName("Test dodawania sal do budynku")
    public void testCreateRoomAndAddToBuilding() {
        // Utwórz nowy budynek
        Building building = new Building();

        // Utwórz sale i dodaj je do budynku
        Room room1 = Room.createRoom(building, "Sala 1", 50);
        Room room2 = Room.createRoom(building, "Sala 2", 100);

        // Sprawdź, czy obiekty sal są dodane do listy sal w budynku
        // Oczekiwany wynik: lista sal w budynku zawiera dwie sale
        assertEquals(2, building.getRooms().size());
        assertTrue(building.getRooms().contains(room1));
        assertTrue(building.getRooms().contains(room2));
    }
}