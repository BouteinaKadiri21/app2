package ca.buthaynatune.app2.services.impl;

import ca.buthaynatune.app2.entities.UserEntity;
import ca.buthaynatune.app2.repositories.UserRepository;
import ca.buthaynatune.app2.services.UserService;
import ca.buthaynatune.app2.shared.Utils;
import ca.buthaynatune.app2.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    Utils util=new Utils();
    @Override
    public UserDto createUser(UserDto user) {
        UserEntity checkUser =userRepository.findByEmail(user.getEmail());
        if(checkUser != null) throw  new RuntimeException("user already exist !");
        UserEntity userEntity=new UserEntity();
        BeanUtils.copyProperties(user,userEntity);
        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userEntity.setUserId(util.generateStringId(32));
        UserEntity newUser = userRepository.save(userEntity);
        UserDto userDto=new UserDto();
        BeanUtils.copyProperties(newUser,userDto);
        return userDto;
    }
}
