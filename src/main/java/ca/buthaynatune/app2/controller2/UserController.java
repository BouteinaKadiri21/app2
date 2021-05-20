package ca.buthaynatune.app2.controller2;

import ca.buthaynatune.app2.requests.UserRequest;
import ca.buthaynatune.app2.responses.UserResponse;
import ca.buthaynatune.app2.services.UserService;
import ca.buthaynatune.app2.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/users")

public class UserController {
    @Autowired
    UserService userService;
    @GetMapping
    public String getUser(){return "get user was called!";}
    @PostMapping
    public UserResponse creatUser(@RequestBody UserRequest userRequest){
        UserDto userDto=new UserDto();
        BeanUtils.copyProperties(userRequest,userDto);
       UserDto createUser= userService.createUser(userDto);
       UserResponse userResponse= new UserResponse();
       BeanUtils.copyProperties(createUser,userResponse);
       return userResponse;
    }
    @PutMapping
    public String updateUser(){return "update user was called!";}
    @DeleteMapping
    public String deleteUser(){return "delete user was called!";}




}