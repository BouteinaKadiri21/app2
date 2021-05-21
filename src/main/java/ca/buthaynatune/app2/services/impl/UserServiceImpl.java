package ca.buthaynatune.app2.services.impl;

import ca.buthaynatune.app2.entities.UserEntity;
import ca.buthaynatune.app2.repositories.UserRepository;
import ca.buthaynatune.app2.services.UserService;
import ca.buthaynatune.app2.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto user) {
        UserEntity userEntity=new UserEntity();
        BeanUtils.copyProperties(user,userEntity);
        //userEntity.setEncryptedPassword("test password le mot de passe");
        userEntity.setUserId("testing userId user");
        UserEntity newUser = userRepository.save(userEntity);
        UserDto userDto=new UserDto();
        BeanUtils.copyProperties(newUser,userDto);
        return userDto;
    }
}
