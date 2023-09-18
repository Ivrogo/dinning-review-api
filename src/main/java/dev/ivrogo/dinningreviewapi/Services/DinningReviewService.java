package dev.ivrogo.dinningreviewapi.Services;

import dev.ivrogo.dinningreviewapi.DTO.ResponseDTO;
import dev.ivrogo.dinningreviewapi.Model.DinningReview;
import dev.ivrogo.dinningreviewapi.Model.ReviewStatus;
import dev.ivrogo.dinningreviewapi.Model.Users;
import org.springframework.http.ResponseEntity;

public interface DinningReviewService {

    ResponseEntity<ResponseDTO> sendReview(Users user);

    ResponseEntity<ResponseDTO> getAllPendingReviews(DinningReview dinningReview);

    ResponseEntity<ResponseDTO> setReviewStatus(DinningReview dinningReview, ReviewStatus reviewStatus);

}
