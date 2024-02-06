package uni.sofia.master.musicportal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import uni.sofia.master.musicportal.models.User;
import uni.sofia.master.musicportal.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        userService.registerUser(user);
        return "redirect:/login"; // Redirect to login page after registration
    }

    @GetMapping("/account")
    public String showUserAccount(@RequestParam Long userId, Model model) {
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "user-account";
    }

    @GetMapping("/recharge")
    public String showRechargePage(@RequestParam Long userId, Model model) {
        model.addAttribute("userId", userId);
        return "recharge-page";
    }

    @PostMapping("/recharge")
    public String rechargeAccount(@RequestParam Long userId, @RequestParam Double amount) {
        userService.rechargeAccount(userId, amount);
        return "redirect:/users/account?userId=" + userId;
    }
}
