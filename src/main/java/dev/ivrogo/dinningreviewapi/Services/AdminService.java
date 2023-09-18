package dev.ivrogo.dinningreviewapi.Services;

import dev.ivrogo.dinningreviewapi.DTO.ResponseDTO;
import dev.ivrogo.dinningreviewapi.Model.AdminReviewAction;
import dev.ivrogo.dinningreviewapi.Model.Restaurant;
import org.springframework.http.ResponseEntity;

public interface AdminService {

    ResponseEntity<ResponseDTO> getReviewByStatus(String reviewStatus);

    ResponseEntity<ResponseDTO> reviewAction(Long id, AdminReviewAction adminReviewAction);

}
