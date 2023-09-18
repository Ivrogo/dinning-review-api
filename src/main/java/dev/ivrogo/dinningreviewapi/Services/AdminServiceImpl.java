package dev.ivrogo.dinningreviewapi.Services;

import dev.ivrogo.dinningreviewapi.DTO.ResponseDTO;
import dev.ivrogo.dinningreviewapi.Model.AdminReviewAction;
import dev.ivrogo.dinningreviewapi.Model.DinningReview;
import dev.ivrogo.dinningreviewapi.Model.Restaurant;
import dev.ivrogo.dinningreviewapi.Model.ReviewStatus;
import dev.ivrogo.dinningreviewapi.Repository.DinningReviewRepository;
import dev.ivrogo.dinningreviewapi.Repository.RestaurantRepository;
import dev.ivrogo.dinningreviewapi.Repository.UserRepository;
import dev.ivrogo.dinningreviewapi.Utils.Updater;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;


@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private DinningReviewRepository dinningReviewRepository;

    @Autowired
    private Updater updater;

    @Override
    public ResponseEntity<ResponseDTO> getReviewByStatus(String review_status) {
        ResponseDTO responseDTO = new ResponseDTO();
        ReviewStatus reviewStatus = ReviewStatus.PENDING;
        try{
            reviewStatus = ReviewStatus.valueOf(review_status.toUpperCase());
        } catch (IllegalArgumentException e) {
            responseDTO.setMessage("Error");
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        List<DinningReview> dinningReviewList = dinningReviewRepository.findByReviewStatus(reviewStatus);
        responseDTO.setMessage("Showing all the reviews according to their status");
        responseDTO.setValue(dinningReviewList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseDTO> reviewAction(Long id, AdminReviewAction adminReviewAction) {
        ResponseDTO responseDTO = new ResponseDTO();

        try {
            Optional<DinningReview> foundReviewOptional = dinningReviewRepository.findById(id);
            if (foundReviewOptional.isEmpty()){
                responseDTO.setMessage("The review was not found in the database");
                return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
            }
            DinningReview review = foundReviewOptional.get();
            //We check if the restaurant exists in the database
            Optional<Restaurant> foundRestaurantOptional = restaurantRepository.findById(review.getRestaurantId());
            if (foundRestaurantOptional.isEmpty()) {
                responseDTO.setMessage("The restaurant does not exist in the database");
                return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
            }

            if (adminReviewAction.getReviewAccepted()){
                review.setReviewStatus(ReviewStatus.APPROVED);
            } else {
                review.setReviewStatus(ReviewStatus.REJECTED);
            }

            dinningReviewRepository.save(review);
            updater.updateRestaurantScores(foundRestaurantOptional.get());
            responseDTO.setMessage("The review and the score update actions have been performed successfully");
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);

        } catch (Exception e) {
            responseDTO.setMessage("Error");
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

