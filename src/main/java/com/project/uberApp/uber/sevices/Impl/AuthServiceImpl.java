package com.project.uberApp.uber.sevices.Impl;

import com.project.uberApp.uber.dto.DriverDto;
import com.project.uberApp.uber.dto.SignupDto;
import com.project.uberApp.uber.dto.UserDto;
import com.project.uberApp.uber.entities.User;
import com.project.uberApp.uber.entities.enums.Role;
import com.project.uberApp.uber.repositories.UserRepository;
import com.project.uberApp.uber.sevices.AuthService;
import com.project.uberApp.uber.sevices.RiderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final RiderService riderService;
    @Override
    public String login(String email, String password) {
        return "";
    }

    @Override
    public UserDto signup(SignupDto signupDto) {
        User user = userRepository.findByEmail(signupDto.getEmail());
        if(user != null){
            throw new RuntimeException("cannot signup, User already exits with email "+signupDto.getEmail());
        }

        User mappedUser = modelMapper.map(signupDto,User.class);
        mappedUser.setRoles(Set.of(Role.RIDER));
        User savedUser = userRepository.save(mappedUser);

        //created user related entities during signup system
//       not only created user but also created so many associated
//       thing like wallet and also rider profile



        return null;
    }

    @Override
    public DriverDto onboardNewDriver(Long userId) {
        return null;
    }
}
