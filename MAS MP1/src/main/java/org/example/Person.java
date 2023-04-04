package org.example;

import com.github.javafaker.Faker;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
@Builder
class Person implements Serializable {

    // atrybut klasowy
    static Set<Person> CACHE = new HashSet<>();

    UUID id;

    String name;

    String surname;

    // atrybut powtarzalny i zlożony
    List<Address> addressList;

    // atrybut opcjonalny
    @NonFinal
    @Setter
    LocalDate birthDate;

    // atrybut pochodny
    public int getAge() {
        if(birthDate == null)
            return LocalDate.now().getYear() - birthDate.getYear();
        else
            return 0;
    }

    // atrybut pochodny
    @SneakyThrows
    public Address getValidAddress() {
        Address validAddress = addressList.stream()
                .filter(Address::isValidAddress)
                .findFirst()
                .orElse(null);

        if (validAddress == null) {
            throw new NoValidAddressException("No valid address found for person: " + this);
        }

        return validAddress;
    }

    // przeciążenie konstruktora
    public Person(String name, String surname, List<Address> addressList) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.addressList = addressList;
        CACHE.add(this);
    }

    // przeciążenie konstruktora

    public Person(String name, String surname, List<Address> addressList, LocalDate birthDate) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.addressList = addressList;
        this.birthDate = birthDate;
        CACHE.add(this);
    }

    // metoda klasowa
    public static Person generatePerson() {
        Faker faker = new Faker();
        List<Address> addressList = new ArrayList<>();
        addressList.add(
                Address.builder()
                        .country(faker.address().country())
                        .city(faker.address().city())
                        .street(faker.address().streetName())
                        .houseNumber(Integer.valueOf(faker.address().buildingNumber()))
                        .apartmentNumber(Integer.valueOf(faker.address().buildingNumber()))
                        .validAddress(true)
                        .build()
        );
        addressList.add(
                Address.builder()
                        .country(faker.address().country())
                        .city(faker.address().city())
                        .street(faker.address().streetName())
                        .houseNumber(Integer.valueOf(faker.address().buildingNumber()))
                        .apartmentNumber(Integer.valueOf(faker.address().buildingNumber()))
                        .validAddress(false)
                        .build()
        );
        Person person = Person.builder()
                .id(UUID.randomUUID())
                .name(faker.name().firstName())
                .surname(faker.name().lastName())
                .addressList(addressList)
                .birthDate(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                .build();
        System.out.println("Generating Person object: " + person);
        CACHE.add(person);
        return person;
    }

    // przesłonięcie metody toString()
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", addressList=" + addressList +
                ", birthDate=" + birthDate +
                '}';
    }
}
