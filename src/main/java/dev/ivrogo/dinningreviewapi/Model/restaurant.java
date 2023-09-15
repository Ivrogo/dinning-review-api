package dev.ivrogo.dinningreviewapi.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "REVIEW_SCORES")
    private Integer avg_review_scores;
    @Column(name = "PEANUT_SCORES")
    private Integer avg_peanut_scores;
    @Column(name = "EGG_SCORES")
    private Integer avg_egg_scores;
    @Column(name = "DAIRY_SCORES")
    private Integer avg_dairy_scores;
}
