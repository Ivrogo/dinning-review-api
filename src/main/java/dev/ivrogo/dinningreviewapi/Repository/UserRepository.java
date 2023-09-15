package dev.ivrogo.dinningreviewapi.Repository;

import dev.ivrogo.dinningreviewapi.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

        Optional<Users> findUserByName(String name);

}

