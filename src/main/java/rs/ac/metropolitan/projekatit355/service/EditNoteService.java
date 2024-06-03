package rs.ac.metropolitan.projekatit355.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import rs.ac.metropolitan.projekatit355.model.UserNote;
import rs.ac.metropolitan.projekatit355.repositories.NoteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EditNoteService {

    @Autowired
    NoteRepository noteRepository;

    public List<UserNote> getAllUserNotes() {
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();

        List<UserNote> notesList = noteRepository.findAllByUsernameOrderByTitle(currentUser.getName());
        return notesList;
    }

    public Optional<UserNote> getUserNote(Long userId) {
        return noteRepository.findById(userId);
    }

    public void saveNote(UserNote userNote){
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        userNote.setUsername(currentUser.getName());

        noteRepository.save(userNote);
    }

    public void deleteNote (UserNote userNote){
        noteRepository.delete(userNote);
    }

}
