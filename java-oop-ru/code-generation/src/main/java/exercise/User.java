package exercise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

// BEGIN
@Getter
@Setter
@Value
@AllArgsConstructor
// END
class User {
    int id;
    String firstName;
    String lastName;
    int age;

}

