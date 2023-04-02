package org.example;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

import java.io.Serializable;
import java.util.*;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
class Person implements Serializable {

    static Set<Person> CACHE = new HashSet<>();

    UUID id;

    String name;

    String surname;

    List<Address> addressList;
    @NonFinal
    @Setter
    String email;

    Person(String name, String surname, List<Address> addressList, String email) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.addressList = addressList;
        this.email = email;
        CACHE.add(this);
    }

}
