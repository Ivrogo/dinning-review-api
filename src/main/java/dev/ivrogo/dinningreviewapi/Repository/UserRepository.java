package dev.ivrogo.dinningreviewapi.Repository;

import dev.ivrogo.dinningreviewapi.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

        Optional<Users> findUserByUserName(String userName);

        Iterable<Users> findAllUsers();

}
