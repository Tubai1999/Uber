package com.project.uberApp.uber.sevices.Impl;

import com.project.uberApp.uber.dto.DriverDto;
import com.project.uberApp.uber.dto.SignupDto;
import com.project.uberApp.uber.dto.UserDto;
import com.project.uberApp.uber.entities.Driver;
import com.project.uberApp.uber.entities.User;
import com.project.uberApp.uber.entities.enums.Role;
import com.project.uberApp.uber.exceptions.ResourceNotFoundException;
import com.project.uberApp.uber.exceptions.RuntimeConflictException;
import com.project.uberApp.uber.repositories.DriverRepository;
import com.project.uberApp.uber.repositories.UserRepository;
import com.project.uberApp.uber.sevices.*;
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
    private final WalletService walletService;
    private final DriverRepository driverRepository;
    private final DriverService driverService;


    @Override
    public String login(String email, String password) {
        return "";
    }

    @Override
    public UserDto signup(SignupDto signupDto) {
        User user = userRepository.findByEmail(signupDto.getEmail()).orElse(null);
        if(user != null){
            throw  new RuntimeConflictException("cannot signup, User already exits with email" + signupDto.getEmail());
        }

        User mappedUser = modelMapper.map(signupDto, User.class);
        mappedUser.setRoles(Set.of(Role.RIDER));
        User savedUser = userRepository.save(mappedUser);

        //created user related entities during signup system
//       not only created user but also created so many associated
//       thing like wallet and also rider profile

        riderService.createNewRider(savedUser);
        walletService.createNewWallet(savedUser);

        return modelMapper.map(savedUser,UserDto.class);
    }

    @Override
    public DriverDto onboardNewDriver(Long userId,String vehicleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User not found with id: "+userId));
        if(user.getRoles().contains(Role.DRIVER))
            throw new RuntimeConflictException("user id with id "+userId+" is already a driver");
        Driver createdDriver = Driver.builder()
                .user(user)
                .rating(0.0)
                .vehicleId(vehicleId)
                .available(true)
                .build();
        Driver savedDriver = driverService.createNewDriver(createdDriver);
        return modelMapper.map(savedDriver,DriverDto.class);
    }
}
