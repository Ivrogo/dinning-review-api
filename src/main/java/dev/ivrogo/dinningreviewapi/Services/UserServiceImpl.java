package dev.ivrogo.dinningreviewapi.Services;

import dev.ivrogo.dinningreviewapi.DTO.RegisterUserDTO;
import dev.ivrogo.dinningreviewapi.DTO.ResponseDTO;
import dev.ivrogo.dinningreviewapi.DTO.UserUpdateDTO;
import dev.ivrogo.dinningreviewapi.Mapper.FromDTOtoEntity;
import dev.ivrogo.dinningreviewapi.Model.Users;
import dev.ivrogo.dinningreviewapi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<ResponseDTO> registerUser(RegisterUserDTO registerUserDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            if(registerUserDTO.getName().isEmpty() || registerUserDTO.getCity().isEmpty() || registerUserDTO.getState().isEmpty() || registerUserDTO.getEmail().isEmpty()) {
                responseDTO.setMessage("The values cannot be empty");
                return new ResponseEntity<>(responseDTO, HttpStatus.NO_CONTENT);
            } else if (registerUserDTO.getName() == null || registerUserDTO.getEmail() == null) {
                responseDTO.setMessage("The values cannot be NULL");
                return new ResponseEntity<>(responseDTO, HttpStatus.CONFLICT);
            }

            //We check if the user exists already in the database
            Optional<Users> findIfUserExists = userRepository.findUserByName(registerUserDTO.getName());
            if (findIfUserExists.isPresent()) {
                responseDTO.setMessage("A user with that name already exists please use a diferent name");
                return new ResponseEntity<>(responseDTO, HttpStatus.CONFLICT);
            }
                Users user = FromDTOtoEntity.fromDTOToEntity(registerUserDTO);
                userRepository.save(user);

                responseDTO.setMessage("User registered successfully");
                responseDTO.setValue(user);
                return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } catch (Exception e) {
            responseDTO.setMessage("Error");
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ResponseDTO> updateUser(UserUpdateDTO userUpdateDTO) {
        ResponseDTO response = new ResponseDTO();
        try {
            if(userUpdateDTO.getEmail().isEmpty() || userUpdateDTO.getCity().isEmpty() || userUpdateDTO.getState().isEmpty() || userUpdateDTO.getZipCode().isEmpty()){
                response.setMessage("The values cannot be empty");
                return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
            } else if (userUpdateDTO.getEmail() == null) {
                response.setMessage("The values cannot be NULL");
                return new ResponseEntity<>(response, HttpStatus.CONFLICT);
            }

            //We validate the username
            Optional<Users> foundUser = userRepository.findUserByName(userUpdateDTO.getName());
            if (foundUser.isEmpty()){
                response.setMessage("The user wasn't found in the database");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            FromDTOtoEntity.UpdateUserFromDTO(foundUser.get(), userUpdateDTO);
            userRepository.save(foundUser.get());

            response.setMessage("User updated successfully");
            response.setValue(foundUser.get());
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {
            response.setMessage("Error");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ResponseDTO> getUser(Long id) {
        ResponseDTO response = new ResponseDTO();
        try {
            //We try to find the user
            Optional<Users> foundUser = userRepository.findById(id);
            if (foundUser.isEmpty()){
                response.setMessage("The user was not found");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            Users existingUser = foundUser.get();
            existingUser.setId(null);

            response.setMessage("The user was found");
            response.setValue(existingUser);
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {
            response.setMessage("Error");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
