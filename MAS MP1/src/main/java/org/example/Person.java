package org.example;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
class Person implements Serializable {

    static List<Person> EXTENSIONS = new ArrayList<>();

    UUID id;

    String name;

    String surname;

    List<Address> addressList;
    @NonFinal
    @Setter
    String email;

}
