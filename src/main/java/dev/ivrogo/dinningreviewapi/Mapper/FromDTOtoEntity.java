package dev.ivrogo.dinningreviewapi.Mapper;

import dev.ivrogo.dinningreviewapi.DTO.RegisterRestaurantDTO;
import dev.ivrogo.dinningreviewapi.DTO.RegisterUserDTO;
import dev.ivrogo.dinningreviewapi.DTO.RegisterUserReviewDTO;
import dev.ivrogo.dinningreviewapi.DTO.UserUpdateDTO;
import dev.ivrogo.dinningreviewapi.Model.DinningReview;
import dev.ivrogo.dinningreviewapi.Model.Restaurant;
import dev.ivrogo.dinningreviewapi.Model.Users;

public class FromDTOtoEntity {

    public static Restaurant fromDTOToEntity(RegisterRestaurantDTO registerRestaurantDTO){

        Restaurant restaurant = new Restaurant();
        restaurant.setName(registerRestaurantDTO.getName());
        restaurant.setAddress(registerRestaurantDTO.getAddress());
        restaurant.setZipCode(registerRestaurantDTO.getZipCode());
        restaurant.setPhone(registerRestaurantDTO.getPhone());
        restaurant.setReviewScore(registerRestaurantDTO.getReviewScore());
        restaurant.setPeanutScore(registerRestaurantDTO.getPeanutScore());
        restaurant.setEggScore(registerRestaurantDTO.getEggScore());
        restaurant.setDairyScore(registerRestaurantDTO.getDairyScore());

        return restaurant;
    }

    public static Users fromDTOToEntity(RegisterUserDTO registerUserDTO){

        Users users = new Users();
        users.setName(registerUserDTO.getName());
        users.setCity(registerUserDTO.getCity());
        users.setZipCode(registerUserDTO.getZipCode());
        users.setEmail(registerUserDTO.getEmail());
        users.setState(registerUserDTO.getState());
        users.setEggAllergies(registerUserDTO.isEggAllergies());
        users.setPeanutAllergies(registerUserDTO.isPeanutAllergies());
        users.setDairyAllergies(registerUserDTO.isDairyAllergies());

        return users;
    }

    public static DinningReview fromDTOToEntity(RegisterUserReviewDTO registerUserReviewDTO) {

        DinningReview dinningReview = new DinningReview();
        dinningReview.setReviewer(registerUserReviewDTO.getReviewer());
        dinningReview.setRestaurantId(registerUserReviewDTO.getRestaurantId());
        dinningReview.setPeanutScore(registerUserReviewDTO.getPeanutScore());
        dinningReview.setEggScore(registerUserReviewDTO.getEggScore());
        dinningReview.setDairyScore(registerUserReviewDTO.getDairyScore());
        dinningReview.setCommentary(registerUserReviewDTO.getCommentary());

        return dinningReview;
    }


    public static void UpdateUserFromDTO(Users user, UserUpdateDTO userUpdateDTO) {

        user.setName(userUpdateDTO.getName());
        user.setCity(userUpdateDTO.getCity());
        user.setState(userUpdateDTO.getState());
        user.setEmail(userUpdateDTO.getEmail());
        user.setZipCode(userUpdateDTO.getZipCode());
        user.setPeanutAllergies(userUpdateDTO.getPeanutAllergies());
        user.setDairyAllergies(userUpdateDTO.getDairyAllergies());
        user.setEggAllergies(userUpdateDTO.getEggAllergies());
    }

}
