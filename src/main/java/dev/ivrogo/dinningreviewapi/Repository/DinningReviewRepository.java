package dev.ivrogo.dinningreviewapi.Repository;

import dev.ivrogo.dinningreviewapi.Model.DinningReview;
import dev.ivrogo.dinningreviewapi.Model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DinningReviewRepository extends JpaRepository<DinningReview, Long> {

    List<DinningReview> findByApprovedFalse();
    List<DinningReview> findByRestaurantAndApprovedTrue(Restaurant restaurant);
    List<DinningReview> getAllReviews();

}
