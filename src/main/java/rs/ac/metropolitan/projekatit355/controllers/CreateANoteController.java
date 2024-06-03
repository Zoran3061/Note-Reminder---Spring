package rs.ac.metropolitan.projekatit355.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import rs.ac.metropolitan.projekatit355.model.UserNote;
import rs.ac.metropolitan.projekatit355.service.CreateANoteServiceImpl;

import javax.validation.Valid;


@Controller
public class CreateANoteController {

    @Autowired
    CreateANoteServiceImpl createANoteService;

    @GetMapping(value = "/CreateANote")
    public String createANote(Model model) {

        model.addAttribute("UserNote", new UserNote());

        return "createANote";
    }

    @PostMapping(value = "/CreateANote")
    public String saveANote(@ModelAttribute("UserNote") @Valid UserNote note, BindingResult result, Model model) {

        if (!result.hasErrors()) {
            createANoteService.saveANoteUsingCurrentUser(note);
            model.addAttribute("noteSaved", true);
        } else {
            model.addAttribute("noteFailedToSave", true);
        }

        return "createANote";
    }

}