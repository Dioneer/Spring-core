package Pegas.http.controller;

import Pegas.dto.LoginDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage(){
        return "user/login";
    }

    @PostMapping("/login")
    public String login(Model model, @ModelAttribute("login") LoginDTO loginDTO){
        return "redirect:/login";
    }
}
