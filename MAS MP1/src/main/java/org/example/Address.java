package org.example;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

import java.io.Serializable;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
class Address implements Serializable {

    String country;

    String city;

    String street;
    @NonFinal
    @Setter
    boolean currentAddress;

}
