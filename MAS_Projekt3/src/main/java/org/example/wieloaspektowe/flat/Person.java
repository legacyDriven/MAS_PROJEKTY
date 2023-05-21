package org.example.wieloaspektowe.flat;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public abstract class Person {

    Gender gender;
}
