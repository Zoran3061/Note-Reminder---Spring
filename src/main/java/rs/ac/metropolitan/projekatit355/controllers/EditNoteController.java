package rs.ac.metropolitan.projekatit355.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import rs.ac.metropolitan.projekatit355.model.UserNote;
import rs.ac.metropolitan.projekatit355.service.EditNoteService;

@Controller
public class EditNoteController {

    @Autowired
    EditNoteService editNoteService;

    @GetMapping(value = "EditNote/{id}")
    public String editNote(@PathVariable("id")Long id, Model model){

        UserNote userNote = editNoteService.getUserNote(id).get();
        model.addAttribute("userNote",userNote);

        return "editNote";

    }

    @PostMapping(value = "EditNote/{id}", params = "submit=edit")
    public String saveNote(@ModelAttribute("userNote")UserNote note){

        editNoteService.saveNote(note);

        return "redirect:/myNotes";
    }

    @PostMapping(value = "EditNote/{id}", params = "submit=delete")
    public String deleteNote(@ModelAttribute("userNote")UserNote parsedUserNote){

        System.out.println(parsedUserNote);

        editNoteService.deleteNote(parsedUserNote);

        return "redirect:/myNotes";
    }
}
