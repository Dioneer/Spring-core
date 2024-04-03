package Pegas.http.controller;

import Pegas.dto.UserCreateEditDto;
import Pegas.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public String findAll(Model model){
//        model.addAttribute("users", userService.findAll());
        return "user/users";
    }
    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model) throws SQLException, InterruptedException {
        model.addAttribute("users", userService.findUserById(id));
        return "user/users";
    }
    @PostMapping
    public String create(@ModelAttribute UserCreateEditDto user){
//        userService.create(user);
        return "redirect:/users"+25;
    }
    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") Long id, @ModelAttribute UserCreateEditDto user){
//        userService.update(id, user);
        return "redirect:/users/{id}";
    }
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id){
//        userService.delete(id);
        return "redirect:/users";
    }
}
