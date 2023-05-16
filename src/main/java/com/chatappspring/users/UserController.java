package com.chatappspring.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }


    @PostMapping("/register")
    public String handleUserRegistration(User user) {
        try {
            this.userService.createUser(user);

            return "redirect:login?status=REGISTER_SUCCESS";
        } catch (Exception exception) {
            //handle errors,  show errors to user
            exception.printStackTrace();
            return "redirect:register?status=REGISTER_FAILED&message=" + exception.getMessage();
        }
    }

    @GetMapping("/login")
    public String displayLoginPage(
            @RequestParam(name = "status", required = false) String status,
            @RequestParam(name = "message", required = false) String message,
            Model model
    ) {
        model.addAttribute("status", status);
        model.addAttribute("status", status);
        return "login"; //return file
    }


    @PostMapping("/login")
    public String handleLogin(LoginRequest loginRequest) {
        try {
            User loggedInUser = this.userService.verifyUser(loginRequest.username, loginRequest.password);
            //save  user id to cookie / session
            return "redirect:chat-room"; //it is endpoint
        } catch (Exception exception) {
            return "redirect:login?status=LOGIN_FAILED&message=" + exception.getMessage();
        }

    }
}