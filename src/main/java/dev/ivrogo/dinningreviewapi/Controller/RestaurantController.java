package dev.ivrogo.dinningreviewapi.Controller;

import dev.ivrogo.dinningreviewapi.DTO.RegisterRestaurantDTO;
import dev.ivrogo.dinningreviewapi.DTO.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface RestaurantController {

    ResponseEntity<ResponseDTO> registerRestaurant(@RequestBody RegisterRestaurantDTO registerRestaurantDTO);

    ResponseEntity<ResponseDTO> getRestaurant(@RequestParam(value = "restaurantId", required = true) Long id);

    ResponseEntity<ResponseDTO> getAllRestaurant();

    ResponseEntity<ResponseDTO> searchRestaurants(@RequestParam(value = "Zipcode", required = true) String zipCode, @RequestParam(value = "Allergy", required = true) String allergy);

}
