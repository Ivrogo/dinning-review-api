package dev.ivrogo.dinningreviewapi.Controller;

import dev.ivrogo.dinningreviewapi.DTO.RegisterUserReviewDTO;
import dev.ivrogo.dinningreviewapi.DTO.ResponseDTO;
import dev.ivrogo.dinningreviewapi.Services.DinningReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class DinningReviewControllerImpl implements DinningReviewController{
    @Autowired
    private DinningReviewService dinningReviewService;
    @Override
    @PostMapping("/NewReview")
    public ResponseEntity<ResponseDTO> addUserReview(RegisterUserReviewDTO registerUserReviewDTO) {
        return dinningReviewService.addUserReview(registerUserReviewDTO);
    }
}
