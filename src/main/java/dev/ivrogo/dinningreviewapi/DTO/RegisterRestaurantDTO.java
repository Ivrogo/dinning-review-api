package dev.ivrogo.dinningreviewapi.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterRestaurantDTO {

    private String name;
    private String address;
    private String zipCode;
    private String phone;
    private String reviewScore;
    private String peanutScore;
    private String eggScore;
    private String dairyScore;

}
