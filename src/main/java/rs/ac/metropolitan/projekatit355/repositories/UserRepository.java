package rs.ac.metropolitan.projekatit355.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.metropolitan.projekatit355.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);

    void removeByUsername(String username);

}
