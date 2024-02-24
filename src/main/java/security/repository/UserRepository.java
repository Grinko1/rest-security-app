package security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import security.models.MyUser;

import java.util.Optional;

public interface UserRepository extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findByName(String name);
}
