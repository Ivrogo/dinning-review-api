package dev.ivrogo.dinningreviewapi.Services;

import dev.ivrogo.dinningreviewapi.DTO.RegisterRestaurantDTO;
import dev.ivrogo.dinningreviewapi.DTO.ResponseDTO;
import org.springframework.http.ResponseEntity;

public interface RestaurantService {

    ResponseEntity<ResponseDTO> registerRestaurant(RegisterRestaurantDTO registerRestaurantDTO);
}
