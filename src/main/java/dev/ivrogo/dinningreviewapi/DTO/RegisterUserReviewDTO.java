package dev.ivrogo.dinningreviewapi.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterUserReviewDTO {

    private String reviewer;
    private Long restaurantId;
    private String peanutScore;
    private String eggScore;
    private String dairyScore;
    private String commentary;

}
