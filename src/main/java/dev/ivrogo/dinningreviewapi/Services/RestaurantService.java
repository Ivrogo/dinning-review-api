package dev.ivrogo.dinningreviewapi.Services;

import dev.ivrogo.dinningreviewapi.DTO.RegisterRestaurantDTO;
import dev.ivrogo.dinningreviewapi.DTO.ResponseDTO;
import dev.ivrogo.dinningreviewapi.Model.Restaurant;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RestaurantService {

    ResponseEntity<ResponseDTO> registerRestaurant(RegisterRestaurantDTO registerRestaurantDTO);

    ResponseEntity<ResponseDTO> getRestaurant(Long id);

    ResponseEntity<ResponseDTO> getAllRestaurants();

    ResponseEntity<ResponseDTO> searchRestaurants(String zipCode, String allergy);
}
