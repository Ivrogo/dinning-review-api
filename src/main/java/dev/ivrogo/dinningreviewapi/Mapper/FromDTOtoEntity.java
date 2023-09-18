package dev.ivrogo.dinningreviewapi.Mapper;

import dev.ivrogo.dinningreviewapi.DTO.RegisterRestaurantDTO;
import dev.ivrogo.dinningreviewapi.DTO.RegisterUserDTO;
import dev.ivrogo.dinningreviewapi.Model.Restaurant;
import dev.ivrogo.dinningreviewapi.Model.Users;

public class FromDTOtoEntity {

    private Restaurant fromDTOToEntity(RegisterRestaurantDTO registerRestaurantDTO){

        Restaurant restaurant = new Restaurant();
        restaurant.setName(registerRestaurantDTO.getName());
        restaurant.setAddress(registerRestaurantDTO.getAddress());
        restaurant.setZipCode(registerRestaurantDTO.getZipCode());
        restaurant.setPhone(registerRestaurantDTO.getPhone());

        return restaurant;
    }

    private Users fromDTOToEntity(RegisterUserDTO registerUserDTO){

        Users users = new Users();
        users.setName(registerUserDTO.getName());
        users.setCity(registerUserDTO.getCity());
        users.setZipCode(registerUserDTO.getZipCode());
        users.setState(registerUserDTO.getState());
        users.setEggAllergies(registerUserDTO.isEggAllergies());
        users.setPeanutAllergies(registerUserDTO.isPeanutAllergies());
        users.setDairyAllergies(registerUserDTO.isDairyAllergies());

        return users;
    }

}
