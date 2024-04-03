package Pegas.http.controller;

import Pegas.dto.UserCreateEditDto;
import Pegas.dto.UserReadDTO;
import Pegas.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("users", userService.findAll());
        return "user/users";
    }
    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model) throws SQLException, InterruptedException {
        model.addAttribute("users", userService.findById(id));
        return userService.findById(id)
                .map(user->{
                    model.addAttribute("user", user);
                   return "user/users";
                }).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public String create(@ModelAttribute UserCreateEditDto user){
        UserReadDTO userReadDTO = userService.create(user);
        return "redirect:/users/"+userReadDTO.getId();
    }
    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") Long id, @ModelAttribute UserCreateEditDto user){
        userService.update(id, user);
        return userService.update(id, user)
                .map(it-> "redirect: users/{id}}")
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id){
       if(!userService.delete(id)){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return "redirect:/users ";
    }
}
