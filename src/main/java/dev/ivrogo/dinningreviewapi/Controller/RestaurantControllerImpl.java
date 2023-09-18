package dev.ivrogo.dinningreviewapi.Controller;

import dev.ivrogo.dinningreviewapi.DTO.RegisterRestaurantDTO;
import dev.ivrogo.dinningreviewapi.DTO.ResponseDTO;
import dev.ivrogo.dinningreviewapi.Services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurants")
public class RestaurantControllerImpl implements RestaurantController{

    @Autowired
    private RestaurantService restaurantService;

    @Override
    @PostMapping("/NewRestaurant")
    public ResponseEntity<ResponseDTO> registerRestaurant(RegisterRestaurantDTO registerRestaurantDTO) {
        return restaurantService.registerRestaurant(registerRestaurantDTO);
    }

    @Override
    @GetMapping("/{name}")
    public ResponseEntity<ResponseDTO> getRestaurant(Long id) {
        return restaurantService.getRestaurant(id);
    }

    @Override
    @GetMapping
    public ResponseEntity<ResponseDTO> getAllRestaurant() {
        return restaurantService.getAllRestaurants();
    }

    @Override
    @GetMapping("/search")
    public ResponseEntity<ResponseDTO> searchRestaurants(String zipCode, String allergy) {
        return restaurantService.searchRestaurants(zipCode, allergy);
    }
}
