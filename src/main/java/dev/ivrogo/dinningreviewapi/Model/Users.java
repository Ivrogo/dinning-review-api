package dev.ivrogo.dinningreviewapi.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, name = "NAME")
    private String name;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE")
    private String state;
    @Column(unique = true, name = "EMAIL")
    private String email;
    @Column(name = "ZIPCODE")
    private String zipCode;
    @Column(name = "PEANUT_ALLERGIES")
    private Boolean peanutAllergies;
    @Column(name = "EGG_ALLERGIES")
    private Boolean eggAllergies;
    @Column(name = "DAIRY_ALLERGIES")
    private Boolean dairyAllergies;

}
