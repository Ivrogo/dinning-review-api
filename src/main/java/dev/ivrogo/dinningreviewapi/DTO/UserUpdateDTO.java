package dev.ivrogo.dinningreviewapi.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDTO {

    private String city;
    private String state;
    private String zipCode;
    private boolean peanutAllergies;
    private boolean eggAllergies;
    private boolean dairyAllergies;
}
