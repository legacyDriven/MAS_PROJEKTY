package org.example.association;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    @Test
    @DisplayName("Test tworzenia sali z właściwościami")
    public void testRoomCreation() {
        // Utwórz nowy budynek
        Building building = new Building();

        // Utwórz salę z podanymi właściwościami
        Room room = Room.createRoom(building, "Sala 1", 50);

        // Sprawdź, czy właściwości sali są ustawione prawidłowo
        // Oczekiwany wynik: budynek, nazwa i rozmiar są zgodne z podanymi wartościami
        assertSame(building, room.getBuilding());
        assertEquals("Sala 1", room.getName());
        assertEquals(50, room.getSize());
    }

    @Test
    @DisplayName("Test metody toString() dla klasy Room")
    public void testRoomToString() {
        // Utwórz nowy budynek
        Building building = new Building();

        // Utwórz salę z podanymi właściwościami
        Room room = Room.createRoom(building, "Sala 1", 50);

        // Sprawdź, czy metoda toString() zwraca oczekiwany ciąg znaków
        // Oczekiwany wynik: ciąg znaków zawierający nazwę sali i jej rozmiar
        String expectedString = "Room{name='Sala 1', size=50}";
        assertEquals(expectedString, room.toString());
    }
}