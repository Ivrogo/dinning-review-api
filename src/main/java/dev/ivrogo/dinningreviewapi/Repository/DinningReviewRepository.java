package dev.ivrogo.dinningreviewapi.Repository;

import dev.ivrogo.dinningreviewapi.Model.DinningReview;
import dev.ivrogo.dinningreviewapi.Model.Restaurant;
import dev.ivrogo.dinningreviewapi.Model.ReviewStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DinningReviewRepository extends JpaRepository<DinningReview, Long> {

    List<DinningReview> findByReviewStatus(ReviewStatus reviewStatus);
    List<DinningReview> findByRestaurantIdAndReviewStatus(long restaurantId, ReviewStatus reviewStatus);

}
