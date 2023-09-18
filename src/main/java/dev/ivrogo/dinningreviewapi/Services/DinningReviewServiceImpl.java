package dev.ivrogo.dinningreviewapi.Services;

import dev.ivrogo.dinningreviewapi.DTO.RegisterUserReviewDTO;
import dev.ivrogo.dinningreviewapi.DTO.ResponseDTO;
import dev.ivrogo.dinningreviewapi.Mapper.FromDTOtoEntity;
import dev.ivrogo.dinningreviewapi.Model.DinningReview;
import dev.ivrogo.dinningreviewapi.Model.Restaurant;
import dev.ivrogo.dinningreviewapi.Model.ReviewStatus;
import dev.ivrogo.dinningreviewapi.Model.Users;
import dev.ivrogo.dinningreviewapi.Repository.DinningReviewRepository;
import dev.ivrogo.dinningreviewapi.Repository.RestaurantRepository;
import dev.ivrogo.dinningreviewapi.Repository.UserRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class DinningReviewServiceImpl implements DinningReviewService{

    @Autowired
    private DinningReviewRepository dinningReviewRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public ResponseEntity<ResponseDTO> addUserReview(RegisterUserReviewDTO registerUserReviewDTO) {
        ResponseDTO responseDTO = new ResponseDTO();

        try {
            if(registerUserReviewDTO.getReviewer().isEmpty() || registerUserReviewDTO.getRestaurantId() == null) {
                responseDTO.setMessage("The values cannot be empty or NULL");
                return new ResponseEntity<>(responseDTO, HttpStatus.CONFLICT);
            }
            //We check that the restaurant is registered in the database
            Optional<Restaurant> foundRestaurantOptional = restaurantRepository.findById(registerUserReviewDTO.getRestaurantId());
            if (foundRestaurantOptional.isEmpty()){
                responseDTO.setMessage("The restaurant wasn't found in the database");
                return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
            }
            //if the restaurant is in the database then we proceed to create an instance of the review to be able to set the status of the one then we save it
            DinningReview review = FromDTOtoEntity.fromDTOToEntity(registerUserReviewDTO);
            review.setReviewStatus(ReviewStatus.PENDING);
            dinningReviewRepository.save(review);

            responseDTO.setMessage("The review has been successfully saved in the database");
            responseDTO.setValue(review);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);

        } catch (Exception e) {
            responseDTO.setMessage("Error");
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
