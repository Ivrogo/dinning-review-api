package dev.ivrogo.dinningreviewapi.Services;

import dev.ivrogo.dinningreviewapi.DTO.RegisterRestaurantDTO;
import dev.ivrogo.dinningreviewapi.DTO.ResponseDTO;
import dev.ivrogo.dinningreviewapi.Mapper.FromDTOtoEntity;
import dev.ivrogo.dinningreviewapi.Model.Restaurant;
import dev.ivrogo.dinningreviewapi.Repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService{
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public ResponseEntity<ResponseDTO> registerRestaurant(RegisterRestaurantDTO registerRestaurantDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            if (registerRestaurantDTO.getName().isEmpty() || registerRestaurantDTO.getZipCode().isEmpty() || registerRestaurantDTO.getAddress().isEmpty() || registerRestaurantDTO.getPhone().isEmpty()) {
                responseDTO.setMessage("The values cannot be empty");
                return new ResponseEntity<>(responseDTO, HttpStatus.NO_CONTENT);
            } else if (registerRestaurantDTO.getName() == null) {
                responseDTO.setMessage("The values cannot be NULL");
                return new ResponseEntity<>(responseDTO, HttpStatus.CONFLICT);
            }

            Restaurant restaurant = FromDTOtoEntity.fromDTOToEntity(registerRestaurantDTO);
            restaurantRepository.save(restaurant);

            responseDTO.setMessage("The restaurant was added successfully");
            responseDTO.setValue(restaurant);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);

        } catch (Exception e) {
            responseDTO.setMessage("Error");
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ResponseDTO> getRestaurant(Long id) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            if(id == null) {
                responseDTO.setMessage("The id cannot be null");
                return new ResponseEntity<>(responseDTO, HttpStatus.CONFLICT);
            }
            //We search for the restaurant
            Optional<Restaurant> foundRestaurantOptional = restaurantRepository.findById(id);
            if (foundRestaurantOptional.isEmpty()){
                responseDTO.setMessage("The restaurant was not found in the database");
                return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
            }

            Restaurant foundRestaurant = foundRestaurantOptional.get();

            responseDTO.setMessage("The restaurant was found successfully");
            responseDTO.setValue(foundRestaurant);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);

        } catch (Exception e) {
            responseDTO.setMessage("Error");
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ResponseDTO> getAllRestaurants() {
        ResponseDTO responseDTO = new ResponseDTO();

        try {
            List<Restaurant> foundRestaurants = restaurantRepository.findAll();
            if (foundRestaurants.isEmpty()) {
                responseDTO.setMessage("There's no restaurant registered in the database");
                return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
            }

            responseDTO.setMessage("Showing all the restaurants");
            responseDTO.setValue(foundRestaurants);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);

        } catch (Exception e) {
            responseDTO.setMessage("Error");
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ResponseDTO> searchRestaurants(String zipCode, String allergy) {
        ResponseDTO responseDTO = new ResponseDTO();

        try {
            Iterable<Restaurant> restaurants = Collections.EMPTY_LIST;
            if (allergy.equalsIgnoreCase("peanut")){
                restaurants = restaurantRepository.findRestaurantsByZipCodeAndPeanutScoreNotNullOrderByPeanutScore(zipCode);
                responseDTO.setMessage("Showing restaurants that has peanut allergy reviews");
                responseDTO.setValue(restaurants);
                return new ResponseEntity<>(responseDTO, HttpStatus.OK);
            } else if (allergy.equalsIgnoreCase("dairy")) {
                restaurants = restaurantRepository.findRestaurantsByZipCodeAndDairyScoreNotNullOrderByDairyScore(zipCode);
                responseDTO.setMessage("Showing restaurants that has dairy allergy reviews");
                responseDTO.setValue(restaurants);
                return new ResponseEntity<>(responseDTO, HttpStatus.OK);
            } else if (allergy.equalsIgnoreCase("egg")) {
                restaurants = restaurantRepository.findRestaurantsByZipCodeAndEggScoreNotNullOrderByEggScore(zipCode);
                responseDTO.setMessage("Showing restaurants that has egg allergy reviews");
                responseDTO.setValue(restaurants);
            } else {
                responseDTO.setMessage("Error bad request");
                return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e){
            responseDTO.setMessage("Error");
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
