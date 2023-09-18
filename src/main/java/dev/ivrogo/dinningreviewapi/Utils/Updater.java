package dev.ivrogo.dinningreviewapi.Utils;

import dev.ivrogo.dinningreviewapi.DTO.ResponseDTO;
import dev.ivrogo.dinningreviewapi.Model.DinningReview;
import dev.ivrogo.dinningreviewapi.Model.Restaurant;
import dev.ivrogo.dinningreviewapi.Model.ReviewStatus;
import dev.ivrogo.dinningreviewapi.Repository.DinningReviewRepository;
import dev.ivrogo.dinningreviewapi.Repository.RestaurantRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.List;

@Component
public class Updater {

    private final DecimalFormat decimalFormat = new DecimalFormat("0.00");
    @Autowired
    private DinningReviewRepository dinningReviewRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    public ResponseEntity<ResponseDTO> updateRestaurantScores(Restaurant restaurant) {
        ResponseDTO responseDTO = new ResponseDTO();

        try {
            List<DinningReview> reviews = dinningReviewRepository.findByRestaurantIdAndReviewStatus(restaurant.getId(), ReviewStatus.APPROVED);
            if (reviews.size() == 0) {
                responseDTO.setMessage("There's no reviews in the database");
                return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
            }

            int peanutSum = 0;
            int peanutCount = 0;
            int dairySum = 0;
            int dairyCount = 0;
            int eggSum = 0;
            int eggCount = 0;
            for (DinningReview r : reviews) {
                if (!ObjectUtils.isEmpty(r.getPeanutScore())) {
                    peanutSum += r.getPeanutScore();
                    peanutCount++;
                }
                if (!ObjectUtils.isEmpty(r.getDairyScore())) {
                    dairySum += r.getDairyScore();
                    dairyCount++;
                }
                if (!ObjectUtils.isEmpty(r.getEggScore())) {
                    eggSum += r.getEggScore();
                    eggCount++;
                }
            }

            int totalCount = peanutCount + dairyCount + eggCount ;
            int totalSum = peanutSum + dairySum + eggSum;

            float overallScore = (float) totalSum / totalCount;
            restaurant.setReviewScore(decimalFormat.format(overallScore));

            if (peanutCount > 0) {
                float peanutScore = (float) peanutSum / peanutCount;
                restaurant.setPeanutScore(decimalFormat.format(peanutScore));
            }

            if (dairyCount > 0) {
                float dairyScore = (float) dairySum / dairyCount;
                restaurant.setDairyScore(decimalFormat.format(dairyScore));
            }

            if (eggCount > 0) {
                float eggScore = (float) eggSum / eggCount;
                restaurant.setEggScore(decimalFormat.format(eggScore));
            }

            Restaurant updatedRestaurant = restaurantRepository.save(restaurant);
            responseDTO.setMessage("The restaurant score has been updated successfully");
            responseDTO.setValue(updatedRestaurant);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);


        } catch (Exception e) {
            responseDTO.setMessage("Error");
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
