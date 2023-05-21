package org.example.wieloaspektowe;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Employee extends Person{

    Integer companyID;

    public Employee(Gender gender, Integer companyID) {
        super(gender);
        this.companyID = companyID;
    }


}
