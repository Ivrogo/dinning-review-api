package dev.ivrogo.dinningreviewapi.Controller;

import dev.ivrogo.dinningreviewapi.DTO.RegisterUserDTO;
import dev.ivrogo.dinningreviewapi.DTO.ResponseDTO;
import dev.ivrogo.dinningreviewapi.DTO.UserUpdateDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserController {

    ResponseEntity<ResponseDTO> registerUser(@RequestBody RegisterUserDTO registerUserDTO);

    ResponseEntity<ResponseDTO> updateUser(@RequestBody UserUpdateDTO userUpdateDTO);

    ResponseEntity<ResponseDTO> getUser(@RequestParam(value = "UserId", required = true) Long id);
}
