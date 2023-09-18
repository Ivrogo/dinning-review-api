package dev.ivrogo.dinningreviewapi.Services;

import dev.ivrogo.dinningreviewapi.DTO.RegisterUserReviewDTO;
import dev.ivrogo.dinningreviewapi.DTO.ResponseDTO;
import dev.ivrogo.dinningreviewapi.Model.DinningReview;
import org.springframework.http.ResponseEntity;

public interface DinningReviewService {

    ResponseEntity<ResponseDTO> addUserReview(RegisterUserReviewDTO registerUserReviewDTO);

}
