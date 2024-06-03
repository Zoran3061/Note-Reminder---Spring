package rs.ac.metropolitan.projekatit355.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import rs.ac.metropolitan.projekatit355.service.EditNoteService;

@Controller
public class MyNotesController {

    @Autowired
    EditNoteService editNoteService;

    @GetMapping(value = "/myNotes")
    public String getNotes(Model model) {

        model.addAttribute("notesList", editNoteService.getAllUserNotes());

        return "myNotes";
    }

}