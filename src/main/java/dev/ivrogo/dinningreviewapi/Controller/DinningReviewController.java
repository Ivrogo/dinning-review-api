package dev.ivrogo.dinningreviewapi.Controller;

import dev.ivrogo.dinningreviewapi.DTO.RegisterUserReviewDTO;
import dev.ivrogo.dinningreviewapi.DTO.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface DinningReviewController {

    ResponseEntity<ResponseDTO> addUserReview(@RequestBody RegisterUserReviewDTO registerUserReviewDTO);

}
