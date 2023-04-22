package org.example;

import lombok.SneakyThrows;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    private Utils() {
       throw new AssertionError("Cannot create instance of utility class");
    }

    //serializacja person do pliku
    public static void serializePersons(List<Person> persons, String fileName) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            // Serializacja kolekcji obiektów Person do pliku
            out.writeObject(persons);
        }
    }

    //deserializacja person z pliku
    public static List<Person> deserializePersons(String fileName) throws IOException, ClassNotFoundException {
        List<Person> persons = new ArrayList<>();

        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            while (fileIn.available() > 0) {
                // Odczytanie obiektu Person z pliku i deserializacja
                Person person = (Person) in.readObject();
                persons.add(person);
            }
        }
        return persons;
    }

}
