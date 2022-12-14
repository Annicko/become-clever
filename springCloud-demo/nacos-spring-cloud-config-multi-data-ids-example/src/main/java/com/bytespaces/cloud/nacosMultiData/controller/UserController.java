package com.bytespaces.cloud.nacosMultiData.controller;


import com.bytespaces.cloud.nacosMultiData.model.User;
import com.bytespaces.cloud.nacosMultiData.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {this.userService = userService;}

    /**
     * http://localhost:8080/user?id=1
     */
    @GetMapping
    @ResponseBody
    public User get(@RequestParam long id) {
        return userService.findById(id);
    }

}