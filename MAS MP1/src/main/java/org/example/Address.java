package org.example;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Builder
@ToString
@EqualsAndHashCode
class Address implements Serializable {

    private static final Set<Address> CACHE = new HashSet<>();

    String country;

    String city;

    String street;

    Integer houseNumber;

    Integer apartmentNumber;

    @NonFinal
    @Setter
    boolean validAddress;

    public Address(String country, String city, String street, String postalCode, Integer houseNumber) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = null;
        this.validAddress = true;
        CACHE.add(this);
    }
}
