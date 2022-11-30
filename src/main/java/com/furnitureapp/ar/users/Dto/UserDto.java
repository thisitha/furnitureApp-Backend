package com.furnitureapp.ar.users.Dto;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
 
public class UserDto {
    private String Uid;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String fcmId;
    private String profileImageUrl;
}


