package Pegas.http.controller;

import Pegas.dao.CompanyRepository;
import Pegas.dto.UserReadDTO;
import Pegas.entity.Role;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@SessionAttributes({"user"})
public class GreetingController {

    @ModelAttribute("roles")
    public List<Role> getRoles(){
        return Arrays.asList(Role.values());
    }

    @GetMapping("/hello")
    public String hello(Model model, UserReadDTO userReadDTO){
     model.addAttribute("user",userReadDTO);
     return "greeting/hello";
    }

    @GetMapping("/hello/{id}")
    public String hello(CompanyRepository companyRepository, HttpServletRequest request,
                              @RequestParam("age") Integer age,
                              @RequestHeader("accept") String accept,
                              @CookieValue ("JSESSIONID") String jsessionId,
                              Model model,
                              UserReadDTO userReadDTO){
        model.addAttribute("user", userReadDTO);
        return "greeting/hello";
    }
    @GetMapping("/bye")
    public String bye(@SessionAttribute("user") UserReadDTO user){
        return "greeting/bye";
    }
}
