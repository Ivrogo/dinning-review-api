package dev.ivrogo.dinningreviewapi.Controller;

import dev.ivrogo.dinningreviewapi.DTO.ResponseDTO;
import dev.ivrogo.dinningreviewapi.Model.AdminReviewAction;
import dev.ivrogo.dinningreviewapi.Model.Restaurant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface AdminController {

    ResponseEntity<ResponseDTO> getReviewByStatus(@RequestParam String reviewStauts);

    ResponseEntity<ResponseDTO> reviewAction(@RequestParam Long id, AdminReviewAction adminReviewAction);

}
