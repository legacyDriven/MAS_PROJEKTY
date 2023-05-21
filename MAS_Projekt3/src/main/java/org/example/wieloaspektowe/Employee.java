package org.example.wieloaspektowe;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Employee extends Person{

    Integer companyID;

    public Employee(@NonNull Gender gender) {
        super(gender);
    }


}
