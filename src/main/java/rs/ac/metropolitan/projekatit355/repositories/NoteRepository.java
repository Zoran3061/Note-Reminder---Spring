package rs.ac.metropolitan.projekatit355.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.metropolitan.projekatit355.model.UserNote;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<UserNote, Long> {

    List<UserNote> findAllByUsernameOrderByTitle(String username);

    Optional<UserNote> findById(Long id);

}
