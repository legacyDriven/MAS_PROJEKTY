package org.example;

import java.io.*;
import java.util.Set;


public class Utils {

    private Utils() {
       throw new AssertionError("Cannot create instance of utility class");
    }

    public static void serializePersonsFromLocalCache() throws IOException {
        File file = new File("src/main/resources/persons.ser");
        if (!file.exists()) {
            file.getParentFile().mkdirs(); // Tworzy katalogi, jeśli nie istnieją
            file.createNewFile(); // Tworzy plik
        }

        try (FileOutputStream fileOut = new FileOutputStream(file);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            // Serializacja kolekcji obiektów Person do pliku
            out.writeObject(Person.CACHE);
        }
    }

    public static Set<Person> deserializePersons() throws IOException, ClassNotFoundException {
        Set<Person> persons;

        try (FileInputStream fileIn = new FileInputStream("src/main/resources/persons.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            persons = (Set<Person>) in.readObject();
        }
        Person.CACHE.addAll(persons);
        return persons;
    }

    public static void generatePerson() {
        Person.generatePerson();
    }

    public static void showPersonsBasicInfoFromLocalCache() {
        Person.showPersonsInfoFromLocalCache();
    }

    public static void showPersonsDetailedInfoFromLocalCache() {
        Person.showPersonsInfoFromLocalCache(true);
    }

    public static void clearLocalCache() {
        Person.CACHE.clear();
    }
}
