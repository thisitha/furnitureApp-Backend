package com.furnitureapp.ar.users;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.furnitureapp.ar.users.Dto.UserDto;
import com.furnitureapp.ar.users.Dto.UserFcmDto;
import com.furnitureapp.ar.users.Dto.UserLoginDto;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/registerUser")
    public ResponseEntity<Object> registerUser(@RequestBody UserDto userDto){
    
       Map<String, Object> map = new HashMap<String, Object>();
        if(userService.registerUser(userDto).getUserEmail()!=null){
            map.put("timestamp", new Date());
           // map.put("status", "");
            map.put("isSuccess", true);
            map.put("message", "User Registerd");
             

            return new ResponseEntity<Object>(map,HttpStatus.ACCEPTED);
        }else{
            map.clear();
            map.put("timestamp", new Date());
         //   map.put("status", "Failed");
            map.put("isSuccess",false);
            map.put("message","Invalid Data");
            
            return new ResponseEntity<Object>(map,HttpStatus.FORBIDDEN);
        }  
    }

    @PostMapping("/updateFcm")
    public Integer updateFcmToken(@RequestBody UserFcmDto userFcmDto ){
            return userService.updateFcmToken(userFcmDto); 
    }

    
    @PostMapping("/getUsers")
    public ResponseEntity<Object> loginUser(@RequestBody UserLoginDto userLoginDto){
       List<UserDto> userList =  userService.loginUser(userLoginDto);
        Map<String, Object> map = new HashMap<String, Object>();
        if(userList.size()!=0){
            map.put("timestamp", new Date());
            map.put("status", "");
            map.put("isSuccess", true);
            map.put("message", "Success");
            map.put("data", userList);

            return new ResponseEntity<Object>(map,HttpStatus.ACCEPTED);
        }else{
            map.clear();
            map.put("timestamp", new Date());
            map.put("status", "Failed");
            map.put("isSuccess",false);
            map.put("message","Invalid Credentials");
            map.put("data", null);
            return new ResponseEntity<Object>(map,HttpStatus.FORBIDDEN);
        }
 
    }

    @GetMapping("/updateUser")
    public ResponseEntity<Object> deleteCartItems(@RequestParam String userId, String userName, String userEmail){
        int result = userService.updateUser( userName, userEmail, userId);
          Map<String, Object> map = new HashMap<String, Object>();
        if(result>0){
            List<Object> cartObjects = new ArrayList<>();
            map.put("timestamp", new Date());
            map.put("isSuccess", true);
            map.put("userState", "User Details Updated");
            //map.put("data", cartObjects);  
            return new ResponseEntity<Object>(map,HttpStatus.ACCEPTED);
        }else{
            List<Object> cartObjects = new ArrayList<>();
            map.put("timestamp", new Date());
            map.put("isSuccess", false);
            map.put("productData", "No such user exist");
          //uUu  map.put("data", cartObjects);  
            return new ResponseEntity<Object>(map,HttpStatus.ACCEPTED);
        }

    }

    @GetMapping("/updatePassword")
    public ResponseEntity<Object> updatePassword(@RequestParam String userId, String currentPassword, String newPassword){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<UserDto> currentUserData  = userService.getUserFromID(userId);
            
        if(currentUserData.get(0).getUserPassword().equals(currentPassword)){
            int result = userService.updatePassword(userId,newPassword);
            System.out.print(userId+"----"+newPassword+"-----"+ result);
                if(result>0){
                    map.put("timestamp", new Date());
                    map.put("isSuccess", true);
                    map.put("userState", "User Details Updated");
                     
                    return new ResponseEntity<Object>(map,HttpStatus.ACCEPTED);
                }

            map.put("timestamp", new Date());
            map.put("isSuccess", false);
            map.put("userState", "User Does Not exist");
            
            return new ResponseEntity<Object>(map,HttpStatus.ACCEPTED);

        }
          else{
           /// List<Object> cartObjects = new ArrayList<>();
            map.put("timestamp", new Date());
            map.put("isSuccess", false);
            map.put("productData", "Passwords Do not match");

            return new ResponseEntity<Object>(map,HttpStatus.ACCEPTED);
        }

        } catch (Exception e) {
            map.put("timestamp", new Date());
            map.put("isSuccess", false);
            map.put("productData", e);

            return new ResponseEntity<Object>(map,HttpStatus.ACCEPTED);
            
        }
        //int result = userService.updatePassword(userId,currentPassword,newPassword);
        
    }
}
