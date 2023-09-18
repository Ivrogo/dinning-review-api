package dev.ivrogo.dinningreviewapi.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDTO {
    
    private String city;
    private String state;
    private String email;
    private String zipCode;
    private Boolean peanutAllergies;
    private Boolean eggAllergies;
    private Boolean dairyAllergies;
}
