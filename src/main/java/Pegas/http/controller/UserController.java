package Pegas.http.controller;

import Pegas.dto.*;
import Pegas.entity.Role;
import Pegas.service.CompanyService;
import Pegas.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final CompanyService companyService;

    @GetMapping
    public String findAll(Model model, FilterDTO filterDTO, Pageable pageable){
//        model.addAttribute("users", userService.findAll());
        Page<UserReadDTO> page = userService.findAll(filterDTO, pageable);
        model.addAttribute("users", PageResponse.of(page));
        model.addAttribute("filter", filterDTO);
        return "user/users";
    }

    @GetMapping("/registration")
    public String registration(Model model, @ModelAttribute("user") UserCreateEditDto user){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        model.addAttribute("companies", companyService.findAll());
        return "user/registration";
    }
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model,
                           @CurrentSecurityContext SecurityContext securityContext,
                           @AuthenticationPrincipal UserDetails userDetails){
        model.addAttribute("users", userService.findById(id));
        return userService.findById(id)
                .map(user->{
                    model.addAttribute("roles", Role.values());
                    model.addAttribute("user", user);
                    model.addAttribute("companies",companyService.findAll());
                   return "user/user";
                }).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public String create(@ModelAttribute @Valid UserCreateEditDto user, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()) {
//            redirectAttribute.addAttribute("username", user.getUsername());
//            redirectAttribute.addFlashAttribute("firstname", user.getFirstname());
            redirectAttributes.addFlashAttribute("user", user);
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/users/registration";
        }
        UserReadDTO userReadDTO = userService.create(user);
        return "redirect:/users/" + userReadDTO.getId();
    }
    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") Long id, @ModelAttribute @Valid UserCreateEditDto user,
                         BindingResult bindingResult,  RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/users/{id}";
        }
        userService.update(id, user);
        return userService.update(id, user)
                .map(it-> "redirect:/users/{id}")
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id){
       if(!userService.delete(id)){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return "redirect:/users";
    }
}
