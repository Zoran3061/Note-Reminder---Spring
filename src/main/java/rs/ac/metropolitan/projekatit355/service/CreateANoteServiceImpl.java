package rs.ac.metropolitan.projekatit355.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import rs.ac.metropolitan.projekatit355.model.User;
import rs.ac.metropolitan.projekatit355.model.UserNote;
import rs.ac.metropolitan.projekatit355.repositories.NoteRepository;
import rs.ac.metropolitan.projekatit355.repositories.UserRepository;

import javax.transaction.Transactional;

@Service
public class CreateANoteServiceImpl {

    @Autowired
    NoteRepository noteRepository;

    @Autowired

    UserRepository userRepository;

    @Transactional
    public void saveANoteUsingCurrentUser(UserNote userNote) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User user = userRepository.findByUsername(authentication.getName());

        userNote.setUsername(user.getUsername());
        userNote.setTitle(userNote.getTitle());
        userNote.setNoteContent(userNote.getNoteContent());

        noteRepository.save(userNote);
    }

    @Transactional
    public void saveANote(UserNote userNote) {
        noteRepository.save(userNote);
    }


}
