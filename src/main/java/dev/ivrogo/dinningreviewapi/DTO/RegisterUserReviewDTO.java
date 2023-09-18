package dev.ivrogo.dinningreviewapi.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterUserReviewDTO {

    private String reviewer;
    private Long restaurantId;
    private Integer peanutScore;
    private Integer eggScore;
    private Integer dairyScore;
    private String commentary;

}
