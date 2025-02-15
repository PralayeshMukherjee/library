package com.raj.library.controller;

import com.raj.library.DTO.UserLoginRequest;
import com.raj.library.Service.SellerService;
import com.raj.library.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private UserService userService;
    @PostMapping("/userLogin")
    public Map<String, Boolean> userChecker(@RequestBody UserLoginRequest userLoginRequest){
        String username = userLoginRequest.getUsername();
        String password = userLoginRequest.getPassword();
        System.out.println(username+" "+password);
//        if(userService.checkUserName(username)){
//            if(userService.checkPassword(password)){
//                return "redirect:/login/UserDetails";
//            }{
//                return "wrongPasswordUser";
//            }
//        }else{
//            return "noUser";
//        }
        boolean isValid = userService.userCheckerService(username,password);
        return Map.of("exists",isValid);
    }
//    @GetMapping("/UserDetails")
//    public String userDetailsShow(Model model){
//        model.addAttribute("details",userService.getUser());
//        return "home";
//    }
}
