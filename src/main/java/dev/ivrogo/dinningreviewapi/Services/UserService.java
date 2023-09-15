package dev.ivrogo.dinningreviewapi.Services;

import dev.ivrogo.dinningreviewapi.DTO.RegisterUserDTO;
import dev.ivrogo.dinningreviewapi.DTO.ResponseDTO;
import dev.ivrogo.dinningreviewapi.DTO.UserUpdateDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<ResponseDTO> registerUser(RegisterUserDTO registerUserDTO);
    ResponseEntity<ResponseDTO> updateUser(UserUpdateDTO userUpdateDTO);

    ResponseEntity<ResponseDTO> getUserById(long id);


}
