package ca.buthaynatune.app2.controller2;

import ca.buthaynatune.app2.requests.UserRequest;
import ca.buthaynatune.app2.responses.UserResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/users")

public class UserController {
    @GetMapping
    public String getUser(){return "get user was called!";}
    @PostMapping
    public UserResponse creatUser(@RequestBody UserRequest userRequest){return null;}
    @PutMapping
    public String updateUser(){return "update user was called!";}
    @DeleteMapping
    public String deleteUser(){return "delete user was called!";}




}