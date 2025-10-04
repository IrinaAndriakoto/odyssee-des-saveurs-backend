package odyssee_des.saveurs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import odyssee_des.saveurs.model.sql.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}