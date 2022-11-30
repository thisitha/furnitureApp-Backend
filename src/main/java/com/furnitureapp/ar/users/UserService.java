package com.furnitureapp.ar.users;

import javax.transaction.Transactional;

 
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furnitureapp.ar.users.Dto.UserDto;
import com.furnitureapp.ar.users.Dto.UserFcmDto;
import com.furnitureapp.ar.users.Dto.UserLoginDto;

import java.util.List;


@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
    public UserDto registerUser(UserDto userDto ){
        userRepo.save(modelMapper.map(userDto, User.class)); 
        return userDto;
    }

    public List<UserDto> loginUser (UserLoginDto userLoginDto){
        List<User> uList = userRepo.findAllUsers(userLoginDto.getUserEmail(),userLoginDto.getUserPassword());
        return modelMapper.map(uList,  new TypeToken<List<UserDto>>(){}.getType());
    }

    public Integer updateFcmToken(UserFcmDto userFcmDto){
        return userRepo.updateFCM(userFcmDto.getFcmId(), userFcmDto.getUid());
    }

    public Integer updateUser(String userName, String userEmail, String userID){
        return userRepo.updateUserProfile(userName, userEmail,userID);
    }
    
    public Integer updatePassword(String userId, String newPassword){
        return userRepo.updateUserPassword(userId,newPassword);
    }
    public List<UserDto> getUserFromID (String uid){
        List<User> uList = userRepo.getUserFromID(uid);
        return modelMapper.map(uList,  new TypeToken<List<UserDto>>(){}.getType());
    }

}
