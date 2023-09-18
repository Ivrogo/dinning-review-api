package dev.ivrogo.dinningreviewapi.Controller;

import dev.ivrogo.dinningreviewapi.DTO.ResponseDTO;
import dev.ivrogo.dinningreviewapi.Model.AdminReviewAction;
import dev.ivrogo.dinningreviewapi.Model.Restaurant;
import dev.ivrogo.dinningreviewapi.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Admin")
public class AdminControllerImpl implements AdminController{

    @Autowired
    private AdminService adminService;
    @Override
    @GetMapping("/reviews")
    public ResponseEntity<ResponseDTO> getReviewByStatus(String reviewStauts) {
        return adminService.getReviewByStatus(reviewStauts);
    }

    @Override
    @GetMapping("/reviews/{id}")
    public ResponseEntity<ResponseDTO> reviewAction(Long id, AdminReviewAction adminReviewAction) {
        return adminService.reviewAction(id, adminReviewAction);
    }
}
