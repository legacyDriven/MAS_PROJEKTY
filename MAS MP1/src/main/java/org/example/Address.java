package org.example;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
class Address implements Serializable {

    private static final Set<Address> CACHE = new HashSet<>();

    String country;

    String city;

    String street;

    Integer houseNumber;

    Integer apartmentNumber;

    @NonFinal
    @Setter
    boolean currentAddress;

}
