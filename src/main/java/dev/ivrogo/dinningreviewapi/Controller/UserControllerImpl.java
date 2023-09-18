package dev.ivrogo.dinningreviewapi.Controller;

import dev.ivrogo.dinningreviewapi.DTO.RegisterUserDTO;
import dev.ivrogo.dinningreviewapi.DTO.ResponseDTO;
import dev.ivrogo.dinningreviewapi.DTO.UserUpdateDTO;
import dev.ivrogo.dinningreviewapi.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Users")
public class UserControllerImpl implements UserController{

    @Autowired
    private UserService userService;

    @Override
    @PostMapping("/NewUser")
    public ResponseEntity<ResponseDTO> registerUser(RegisterUserDTO registerUserDTO) {
        return userService.registerUser(registerUserDTO);
    }

    @Override
    @PutMapping("/UpdateUser/{name}")
    public ResponseEntity<ResponseDTO> updateUser(UserUpdateDTO userUpdateDTO) {
        return userService.updateUser(userUpdateDTO);
    }

    @Override
    @GetMapping("/{name}")
    public ResponseEntity<ResponseDTO> getUser(Long id) {
        return userService.getUser(id);
    }
}
