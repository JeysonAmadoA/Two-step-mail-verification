package com.Triju.UserService.Services.Interfaces;

import com.Triju.UserService.Dto.Users.ActivateUserDto;
import com.Triju.UserService.Dto.Users.RegisterUserDto;
import com.Triju.UserService.Dto.Users.UserDto;
import com.Triju.UserService.Entities.User;
import static com.Triju.UserService.Helpers.UserHelper.*;

import com.Triju.UserService.Exceptions.PasswordNotMatchException;
import com.Triju.UserService.Exceptions.UserNotFoundException;
import com.Triju.UserService.Mappers.UserMapper;
import com.Triju.UserService.Repositories.UserRepository;
import com.Triju.UserService.Services.Implementation.UserEventService;
import com.Triju.UserService.Services.Implementation.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserEventService userEventService;

    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserEventService userEventService, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userEventService = userEventService;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto createUser(RegisterUserDto userDto) throws PasswordNotMatchException {
        verifyPassword(userDto.getPassword(), userDto.getConfirmPassword());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encryptedPassword = encoder.encode(userDto.getPassword());
        String activationToken = generateTokenCode();

        System.out.println(activationToken);
        User user = userMapper.DtoToEntity(userDto);
        user.setPassword(encryptedPassword);
        user.setActivationToken(encoder.encode(activationToken));
        try {
            User userCreated = userRepository.save(user);
            userEventService.publishEvent(userMapper.EntityToDto(userCreated, activationToken));
            return userMapper.EntityToDto(userCreated);
        } catch (Exception e){
            throw new RuntimeException("Error al crear usuario");
        }
    }

    @Override
    public String activateUser(ActivateUserDto activateUserDto) throws UserNotFoundException {
        User userFound = userRepository.findById(activateUserDto.getId())
                .orElseThrow(UserNotFoundException::new);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean isActivated = encoder.matches(activateUserDto.getActivationToken(),
                userFound.getActivationToken());

        if(isActivated){
            userFound.setVerifiedUser(true);
            userRepository.save(userFound);
            return "Activación de usuario completada";
        } else {
            return "No fue posible activar el usuario. El código no coincide";
        }
    }

}
