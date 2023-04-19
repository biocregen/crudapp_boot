package ru.crudboot.myCrudAppBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.crudboot.myCrudAppBoot.model.User;
import ru.crudboot.myCrudAppBoot.service.UserService;


@Controller
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getAllUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUser());
        return "all-users";
    }

    @GetMapping(value = "/add")
    public String addForm(ModelMap model) {
        model.addAttribute("users", new User());
        return "add";
    }

    @PostMapping(value = "/add")
    public String addSumbit(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public String editPage(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("user", userService.getById(id));
        return "edit";
    }

    @PatchMapping(value = "/edit")
    public String editSubmit(@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/";
    }


}
