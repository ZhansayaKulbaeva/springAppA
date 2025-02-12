package kz.bitlab.springApp.controllers;

import kz.bitlab.springApp.db.DBManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", DBManager.getUsers());
        return "users";
    }
}
