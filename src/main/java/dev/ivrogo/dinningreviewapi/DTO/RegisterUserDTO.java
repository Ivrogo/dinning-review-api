package dev.ivrogo.dinningreviewapi.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RegisterUserDTO {

    private String name;
    private String city;
    private String state;
    private String zipCode;
    private boolean peanutAllergies;
    private boolean eggAllergies;
    private boolean dairyAllergies;

}
