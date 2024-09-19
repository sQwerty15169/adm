package com.example.adminka.controller;

import com.example.adminka.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String getUsers(Model model) {
        List<User> users = Arrays.asList(
                new User(1L, "Hierarch Artanis", "Artanis@xto.com", productService.getProductsByIds(Arrays.asList(1L, 3L))),
                new User(2L, "Sarah Kerrigan", "Sarah@test.com", productService.getProductsByIds(Arrays.asList(2L, 3L)))
        );
        model.addAttribute("users", users);
        return "users";
    }
}
