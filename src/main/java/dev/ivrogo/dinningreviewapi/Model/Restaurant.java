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
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "ZIPCODE")
    private String zipCode;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "REVIEW_SCORE")
    private String reviewScore;
    @Column(name = "PEANUT_SCORE")
    private String peanutScore;
    @Column(name = "EGG_SCORE")
    private String eggScore;
    @Column(name = "DAIRY_SCORE")
    private String  dairyScore;
}
