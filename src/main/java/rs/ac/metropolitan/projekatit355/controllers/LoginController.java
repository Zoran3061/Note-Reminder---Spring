package rs.ac.metropolitan.projekatit355.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import rs.ac.metropolitan.projekatit355.model.User;
import rs.ac.metropolitan.projekatit355.service.UserServiceImpl;

@Controller
public class LoginController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping(value = "/login")
    public String login(Model model) {
        return "login";
    }

    @RequestMapping("/loginError")
    public String loginError(Model model) {

        model.addAttribute("loginError", true);
        return "login.html";
    }

    @PostMapping(value = "/login")
    public String login(@RequestParam("login") String username, Model model){
        User user = userService.findByUsername(username);

        if(user == null){
            return "myNotes";
        }

        model.addAttribute("loggedUser", user);

        return "myNotes";
    }
}