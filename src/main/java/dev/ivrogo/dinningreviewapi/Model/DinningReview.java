package dev.ivrogo.dinningreviewapi.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DinningReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "REVIEWER", unique = true)
    private String reviewer;
    @Column(name = "RESTAURANT_ID", unique = true)
    private Long restaurantId;
    @Column(name = "PEANUT_SCORE", nullable = true)
    private String peanutScore;
    @Column(name = "EGG_SCORE", nullable = true)
    private String eggScore;
    @Column(name = "DAIRY_SCORE", nullable = true)
    private String dairyScore;
    @Column(name = "COMMENTARY", nullable = true)
    private String commentary;
    @Column(name = "REVIEW_STAUTS")
    @Enumerated(EnumType.STRING)
    private ReviewStatus reviewStatus;

}
